package br.com.actionsys.kawhycommons.infra.util;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.List;

public class APathUtil {

    public static Boolean hasTag(Document doc, String aPath) {
        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            return (Boolean) xPath.compile(formatExpression(aPath)).evaluate(doc, XPathConstants.BOOLEAN);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String execute(Document doc, String aPath) {
        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            return (String) xPath.compile(formatExpression(aPath)).evaluate(doc, XPathConstants.STRING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String executeOrNull(Document doc, String aPath) {
        String result = execute(doc, aPath);
        return StringUtils.isBlank(result) ? null : result;
    }

    public static String executeNotNull(Document doc, String aPath) {
        try {
            String result = execute(doc, aPath);
            if (StringUtils.isBlank(result)) {
                throw new RuntimeException("Valor não encontrado dentro do XML para o apath : " + aPath);
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> executeList(Document doc, String aPath) throws XPathExpressionException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList) xPath.compile(formatExpression(aPath)).evaluate(doc, XPathConstants.NODESET);
        List<String> result = new ArrayList<>();
        for (int x = 0; x < nodeList.getLength(); x++) {
            result.add(nodeList.item(x).getTextContent());
        }
        return result;
    }

    public static String formatExpression(String inputExpression) {
        String[] tags = inputExpression.split("/");

        StringBuilder outPutExpression = new StringBuilder();

        for (String tag : tags) {

            outPutExpression.append("/");
            if (!StringUtils.equalsAny(tag, new CharSequence[]{"*", "..", "../", "//"})
                    && !StringUtils.containsAny(tag, new CharSequence[]{"::", "@", "()"})) {

                if (tag.contains("|")) {
                    outPutExpression.append("*[");
                    String[] tagsOr = tag.split("\\|");

                    for (String tagOr : tagsOr) {
                        if (!tagOr.equals(tagsOr[0])) {
                            outPutExpression.append(" or ");
                        }
                        outPutExpression.append("name()='").append(tagOr).append("'");
                    }

                    outPutExpression.append("]");

                } else {
                    outPutExpression.append("*[name()='").append(tag).append("']");
                }

            } else {
                outPutExpression.append(tag);
            }
        }

        return outPutExpression.toString();
    }
}
