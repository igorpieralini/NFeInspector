package me.pieralini.com.parser;

import me.pieralini.com.model.*;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.List;

public class NFeParser {

    private static String txt(Element parent, String name, Namespace ns) {
        if (parent == null) return null;

        Element child = parent.getChild(name, ns);
        return child == null ? null : child.getTextNormalize();
    }

    private static Double dbl(Element parent, String name, Namespace ns) {
        String t = txt(parent, name, ns);

        if (t == null || t.isEmpty()) return null;
        try { return Double.parseDouble(t.replace(",", ".")); } catch (Exception e) { return null; }
    }

    public Invoice parse(File xmlFile) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(xmlFile);

        Element rootProc = doc.getRootElement();
        Namespace ns = rootProc.getNamespace();

        Element nfeElem = rootProc.getChild("NFe", ns);
        if (nfeElem == null) nfeElem = rootProc;

        Element infNFe = nfeElem.getChild("infNFe", ns);
        if (infNFe == null) throw new IllegalArgumentException("infNFe not found");

        Invoice invoice = new Invoice();

        Ide ide = new Ide();
        Element ideEl = infNFe.getChild("ide", ns);

        if (ideEl != null) {
            ide.setcUF(txt(ideEl, "cUF", ns));
            ide.setcNF(txt(ideEl, "cNF", ns));
            ide.setNatOp(txt(ideEl, "natOp", ns));
            ide.setMod(txt(ideEl, "mod", ns));
            ide.setSerie(txt(ideEl, "serie", ns));
            ide.setnNF(txt(ideEl, "nNF", ns));
            ide.setDhEmi(txt(ideEl, "dhEmi", ns));
            ide.setDhSaiEnt(txt(ideEl, "dhSaiEnt", ns));
            ide.setTpNF(txt(ideEl, "tpNF", ns));
            ide.setIdDest(txt(ideEl, "idDest", ns));
            ide.setcMunFG(txt(ideEl, "cMunFG", ns));
            ide.setTpAmb(txt(ideEl, "tpAmb", ns));
            ide.setFinNFe(txt(ideEl, "finNFe", ns));
            ide.setIndFinal(txt(ideEl, "indFinal", ns));
            ide.setIndPres(txt(ideEl, "indPres", ns));
            ide.setProcEmi(txt(ideEl, "procEmi", ns));
            ide.setVerProc(txt(ideEl, "verProc", ns));
            Element nfref = ideEl.getChild("NFref", ns);

            if (nfref != null) ide.setRefNFe(txt(nfref, "refNFe", ns));
            ide.setcDV(txt(ideEl, "cDV", ns));
        }
        invoice.setIde(ide);

        Element emitEl = infNFe.getChild("emit", ns);

        if (emitEl != null) {
            Emitter emitter = new Emitter();
            emitter.setCnpj(txt(emitEl, "CNPJ", ns));
            emitter.setName(txt(emitEl, "xNome", ns));
            emitter.setIe(txt(emitEl, "IE", ns));
            emitter.setCrt(txt(emitEl, "CRT", ns));
            emitter.setPhone(txt(emitEl, "fone", ns));
            Element ender = emitEl.getChild("enderEmit", ns);

            if (ender != null) {
                Address a = new Address();
                a.setStreet(txt(ender, "xLgr", ns));
                a.setNumber(txt(ender, "nro", ns));
                a.setNeighborhood(txt(ender, "xBairro", ns));
                a.setCityCode(txt(ender, "cMun", ns));
                a.setCity(txt(ender, "xMun", ns));
                a.setUf(txt(ender, "UF", ns));
                a.setZip(txt(ender, "CEP", ns));
                a.setCountryCode(txt(ender, "cPais", ns));
                a.setCountry(txt(ender, "xPais", ns));
                a.setComplement(txt(ender, "xCpl", ns));
                emitter.setAddress(a);
            }
            invoice.setEmitter(emitter);
        }

        Element destEl = infNFe.getChild("dest", ns);

        if (destEl != null) {
            Recipient r = new Recipient();
            r.setCnpjOrCpf(txt(destEl, "CNPJ", ns) != null ? txt(destEl, "CNPJ", ns) : txt(destEl, "CPF", ns));
            r.setName(txt(destEl, "xNome", ns));
            r.setIndIEDest(txt(destEl, "indIEDest", ns));
            r.setIe(txt(destEl, "IE", ns));
            r.setEmail(txt(destEl, "email", ns));
            r.setPhone(txt(destEl, "fone", ns));
            Element ender = destEl.getChild("enderDest", ns);

            if (ender != null) {
                Address a = new Address();
                a.setStreet(txt(ender, "xLgr", ns));
                a.setNumber(txt(ender, "nro", ns));
                a.setComplement(txt(ender, "xCpl", ns));
                a.setNeighborhood(txt(ender, "xBairro", ns));
                a.setCityCode(txt(ender, "cMun", ns));
                a.setCity(txt(ender, "xMun", ns));
                a.setUf(txt(ender, "UF", ns));
                a.setZip(txt(ender, "CEP", ns));
                a.setCountryCode(txt(ender, "cPais", ns));
                a.setCountry(txt(ender, "xPais", ns));
                r.setAddress(a);
            }
            invoice.setRecipient(r);
        }

        List<Element> dets = infNFe.getChildren("det", ns);

        for (Element det : dets) {
            Product p = new Product();
            p.setItemNumber(det.getAttributeValue("nItem"));
            Element prod = det.getChild("prod", ns);

            if (prod != null) {
                p.setCode(txt(prod, "cProd", ns));
                p.setEan(txt(prod, "cEAN", ns));
                p.setDescription(txt(prod, "xProd", ns));
                p.setNcm(txt(prod, "NCM", ns));
                p.setCfop(txt(prod, "CFOP", ns));
                p.setUnit(txt(prod, "uCom", ns));
                p.setQuantity(dbl(prod, "qCom", ns) == null ? 0.0 : dbl(prod, "qCom", ns));
                p.setUnitValue(dbl(prod, "vUnCom", ns) == null ? 0.0 : dbl(prod, "vUnCom", ns));
                p.setTotalValue(dbl(prod, "vProd", ns) == null ? 0.0 : dbl(prod, "vProd", ns));
                p.setEanTrib(txt(prod, "cEANTrib", ns));
                p.setUnitTrib(txt(prod, "uTrib", ns));
                p.setQuantityTrib(dbl(prod, "qTrib", ns) == null ? 0.0 : dbl(prod, "qTrib", ns));
                p.setUnitValueTrib(dbl(prod, "vUnTrib", ns) == null ? 0.0 : dbl(prod, "vUnTrib", ns));
                p.setIndTot(txt(prod, "indTot", ns));
                p.setOrder(txt(prod, "xPed", ns));
                Element comb = prod.getChild("comb", ns);

                if (comb != null) {
                    Product.CombInfo ci = new Product.CombInfo();
                    ci.setcProdANP(txt(comb, "cProdANP", ns));
                    ci.setDescANP(txt(comb, "descANP", ns));
                    ci.setpGLP(dbl(comb, "pGLP", ns));
                    ci.setpGNn(dbl(comb, "pGNn", ns));
                    ci.setpGNi(dbl(comb, "pGNi", ns));
                    ci.setUfCons(txt(comb, "UFCons", ns));
                    p.setComb(ci);
                }
            }
            Element imp = det.getChild("imposto", ns);

            if (imp != null) {
                Taxes taxes = invoice.getTaxes() != null ? invoice.getTaxes() : new Taxes();
                Element icms = imp.getChild("ICMS", ns);

                if (icms != null) {
                    Element icms61 = icms.getChild("ICMS61", ns);

                    if (icms61 != null) {
                        TaxICMSMono m = new TaxICMSMono();
                        m.setOrig(txt(icms61, "orig", ns));
                        m.setCst(txt(icms61, "CST", ns));
                        m.setqBCMonoRet(dbl(icms61, "qBCMonoRet", ns));
                        m.setAdRemICMSRet(dbl(icms61, "adRemICMSRet", ns));
                        m.setvICMSMonoRet(dbl(icms61, "vICMSMonoRet", ns));
                        taxes.setIcmsMono(m);
                    }
                }
                Element pis = imp.getChild("PIS", ns);

                if (pis != null) {
                    Element pisnt = pis.getChild("PISNT", ns);
                    if (pisnt != null) taxes.setPisCst(txt(pisnt, "CST", ns));
                }
                Element cofins = imp.getChild("COFINS", ns);

                if (cofins != null) {
                    Element cofinsnt = cofins.getChild("COFINSNT", ns);
                    if (cofinsnt != null) taxes.setCofinsCst(txt(cofinsnt, "CST", ns));
                }
                invoice.setTaxes(taxes);
            }
            p.setInfAdProd(txt(det, "infAdProd", ns));
            invoice.addProduct(p);
        }

        Element totalEl = infNFe.getChild("total", ns);

        if (totalEl != null) {
            Element icmstot = totalEl.getChild("ICMSTot", ns);

            if (icmstot != null) {
                Totals t = new Totals();
                t.setvBC(dbl(icmstot, "vBC", ns));
                t.setvICMS(dbl(icmstot, "vICMS", ns));
                t.setvICMSDeson(dbl(icmstot, "vICMSDeson", ns));
                t.setvFCP(dbl(icmstot, "vFCP", ns));
                t.setvBCST(dbl(icmstot, "vBCST", ns));
                t.setvST(dbl(icmstot, "vST", ns));
                t.setvProd(dbl(icmstot, "vProd", ns));
                t.setvFrete(dbl(icmstot, "vFrete", ns));
                t.setvSeg(dbl(icmstot, "vSeg", ns));
                t.setvDesc(dbl(icmstot, "vDesc", ns));
                t.setvII(dbl(icmstot, "vII", ns));
                t.setvIPI(dbl(icmstot, "vIPI", ns));
                t.setvPIS(dbl(icmstot, "vPIS", ns));
                t.setvCOFINS(dbl(icmstot, "vCOFINS", ns));
                t.setvOutro(dbl(icmstot, "vOutro", ns));
                t.setvNF(dbl(icmstot, "vNF", ns));
                t.setqBCMonoRet(dbl(icmstot, "qBCMonoRet", ns));
                t.setvICMSMonoRet(dbl(icmstot, "vICMSMonoRet", ns));
                invoice.setTotals(t);
            }
        }

        Element transpEl = infNFe.getChild("transp", ns);

        if (transpEl != null) {
            Transport tr = new Transport();
            tr.setModFrete(txt(transpEl, "modFrete", ns));
            Element transporta = transpEl.getChild("transporta", ns);

            if (transporta != null) {
                Emitter transporter = new Emitter();
                transporter.setCnpj(txt(transporta, "CNPJ", ns));
                transporter.setName(txt(transporta, "xNome", ns));
                transporter.setIe(txt(transporta, "IE", ns));
                transporter.setPhone(txt(transporta, "fone", ns));

                Address a = new Address();
                a.setStreet(txt(transporta, "xEnder", ns));
                a.setCity(txt(transporta, "xMun", ns));
                a.setUf(txt(transporta, "UF", ns));
                transporter.setAddress(a);
                tr.setTransporter(transporter);
            }
            Element veic = transpEl.getChild("veicTransp", ns);

            if (veic != null) {
                Vehicle v = new Vehicle();
                v.setPlate(txt(veic, "placa", ns));
                v.setUf(txt(veic, "UF", ns));
                tr.setVehicle(v);
            }
            Element vol = transpEl.getChild("vol", ns);

            if (vol != null) {
                Volume vo = new Volume();
                vo.setqVol(txt(vol, "qVol", ns) != null ? Integer.parseInt(txt(vol, "qVol", ns)) : null);
                vo.setEsp(txt(vol, "esp", ns));
                vo.setnVol(txt(vol, "nVol", ns) != null ? Integer.parseInt(txt(vol, "nVol", ns)) : null);
                vo.setPesoL(dbl(vol, "pesoL", ns));
                vo.setPesoB(dbl(vol, "pesoB", ns));
                tr.setVolume(vo);
            }
            invoice.setTransport(tr);
        }

        Element cobrEl = infNFe.getChild("cobr", ns);

        if (cobrEl != null) {
            Billing b = new Billing();
            Element fat = cobrEl.getChild("fat", ns);

            if (fat != null) {
                b.setnFat(txt(fat, "nFat", ns));
                b.setvOrig(dbl(fat, "vOrig", ns));
                b.setvDesc(dbl(fat, "vDesc", ns));
                b.setvLiq(dbl(fat, "vLiq", ns));
            }
            List<Element> dups = cobrEl.getChildren("dup", ns);

            for (Element dup : dups) {
                Duplicate d = new Duplicate();
                d.setnDup(txt(dup, "nDup", ns));
                d.setdVenc(txt(dup, "dVenc", ns));
                d.setvDup(dbl(dup, "vDup", ns));
                b.addDuplicate(d);
            }
            invoice.setBilling(b);
        }

        Element pagEl = infNFe.getChild("pag", ns);

        if (pagEl != null) {
            Element detPag = pagEl.getChild("detPag", ns);

            if (detPag != null) {
                Payment pay = new Payment();
                pay.setIndPag(txt(detPag, "indPag", ns));
                pay.settPag(txt(detPag, "tPag", ns));
                pay.setvPag(dbl(detPag, "vPag", ns));
                invoice.setPayment(pay);
            }
        }

        invoice.setInfAdicional(txt(infNFe, "infAdic", ns) != null ? txt(infNFe.getChild("infAdic", ns), "infCpl", ns) : null);
        Element compra = infNFe.getChild("compra", ns);

        if (compra != null) invoice.setPurchaseOrder(txt(compra, "xPed", ns));

        Element infResp = infNFe.getChild("infRespTec", ns);

        if (infResp != null) {
            TechContact tc = new TechContact();
            tc.setCnpj(txt(infResp, "CNPJ", ns));
            tc.setContact(txt(infResp, "xContato", ns));
            tc.setEmail(txt(infResp, "email", ns));
            tc.setPhone(txt(infResp, "fone", ns));
            invoice.setTechContact(tc);
        }

        Element protNFe = rootProc.getChild("protNFe", ns);

        if (protNFe != null) {
            Element infProt = protNFe.getChild("infProt", ns);

            if (infProt == null) {
                Namespace protNs = Namespace.getNamespace("http://www.portalfiscal.inf.br/nfe");
                infProt = protNFe.getChild("infProt", protNs);
            }

            if (infProt != null) {
                Protocol p = new Protocol();
                p.setTpAmb(txt(infProt, "tpAmb", ns));
                p.setVerAplic(txt(infProt, "verAplic", ns));
                p.setChNFe(txt(infProt, "chNFe", ns));
                p.setDhRecbto(txt(infProt, "dhRecbto", ns));
                p.setnProt(txt(infProt, "nProt", ns));
                p.setDigVal(txt(infProt, "digVal", ns));
                p.setcStat(txt(infProt, "cStat", ns));
                p.setxMotivo(txt(infProt, "xMotivo", ns));
                invoice.setProtocol(p);
            }
        }

        return invoice;
    }
}
