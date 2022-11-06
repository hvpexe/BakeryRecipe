/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.tags;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import utils.Tools;

/**
 *
 * @author Admin
 */
public class MyCustomTag extends SimpleTagSupport {

    private Timestamp value;

    public void setValue (Timestamp value) {
        this.value = value;
    }

    public void doTag ()
            throws JspException, IOException {
        if (value != null) {
            /* Use message from attribute */
            JspWriter out = getJspContext().getOut();
            out.println(Tools.formatDate(value));
        }
    }
}
