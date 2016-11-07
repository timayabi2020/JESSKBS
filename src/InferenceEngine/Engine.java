/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InferenceEngine;

/**
 *
 * @author Tim Mayabi
 */
import java.io.StringWriter;
import javax.swing.JOptionPane;
import jess.JessException;
import jess.Rete;
public class Engine {
    
    public static Rete engine;

    public static void queryInferenceEngine(String s) throws JessException {
        // Create a Jess rule engine
        engine = new Rete();
        engine.reset();
        StringWriter o = new StringWriter();
        engine.addOutputRouter("t", o);
        String result = "";

        // Load the pricing rules
        engine.batch("projects.clp");
        engine.eval(s);
        engine.run();

        result = o.toString();
        engine.clear();
        if (result == null ? "" == null : result.equals("")) {
            result = "Information is currently not available in the knowledge base"
                    + " Please try again";
        }
        JOptionPane.showMessageDialog(null, result);
    }
}
