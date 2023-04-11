package com.discovermarket.claimservice.utilities;

import com.discovermarket.claimservice.entities.Claim;
import com.discovermarket.claimservice.models.TenantResponse;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;

@Component
public class PdfGenaratorUtil {

    @Autowired
    private TemplateEngine templateEngine;

    public byte[] createPdf(String templateName, TenantResponse response, Claim claim) {
        Assert.notNull(templateName, "The templateName can not be null");

        Context ctx = new Context();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ProposalConstants.TEMPLATE_FORMAT_DATE);
        LocalDateTime now = LocalDateTime.now();

        ctx.setVariable("claimEmail", "");
        ctx.setVariable("policyholderEmail", "fullName");
        ctx.setVariable("fnolDate", claim.getDateOfFnol());
        ctx.setVariable("claimName", "");
        ctx.setVariable("claimId", claim.getId());
        ctx.setVariable("tenantName", response.getName());
        ctx.setVariable("tenantAddress", "");
        ctx.setVariable("tenantLogo", response.getLogo());

        String processedHtml = templateEngine.process(templateName, ctx);

        return this.createPdf(processedHtml);
    }

    private byte[] createPdf(String html) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(html, new PdfWriter(byteArrayOutputStream));

        return byteArrayOutputStream.toByteArray();
    }
}
