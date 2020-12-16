/*
 * The MIT License
 *
 * Copyright 2020 ubaid.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package cpk2.pbo.chatapp;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ubaid
 */
public class MainWindow extends JFrame {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jgoodies.plaf.plastic.PlasticXPLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            // Likely PlasticXP is not in the class path; ignore.
        }
        JFrame frame = new JFrame();
        frame.setTitle("Forms Tutorial :: Component Sizes");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JComponent panel = new MainWindow().buildPanel();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    public JComponent buildPanel() {
        JSplitPane splitPane = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT,
            true,
            buildCombinedPanel(), 
            buildTextPanel());
        return splitPane;
    }
    
        
    /**
     * Builds and answer the panel that combines the three sizing panels.
     * 
     * @return the combined panel
     */
    private JComponent buildCombinedPanel() {
        FormLayout layout = new FormLayout(
            "30dlu:grow",
            "pref, 3dlu, pref, 3dlu, pref");
            
        PanelBuilder builder = new PanelBuilder(layout);
        builder.setDefaultDialogBorder();

        CellConstraints cc = new CellConstraints();

//        builder.add(buildMinimumSizePanel(),   cc.xy(1, 1));
        builder.add(buildDefaultSizePanel(),   cc.xy(1, 3));
        builder.add(buildPreferredSizePanel(), cc.xy(1, 5));
        
        return builder.getPanel();
    }
    

    private JComponent buildMinimumSizePanel() {
        FormLayout layout = new FormLayout( 
                "right:max(25dlu;pref), 3dlu, min",
                "pref");
        DefaultFormBuilder builder = new DefaultFormBuilder(layout);
        builder.append("Min", new JTextField(20));
        return builder.getPanel();
    }
    
    private JComponent buildDefaultSizePanel() {
        FormLayout layout = new FormLayout(
                "right:max(25dlu;pref), 3dlu, default",
                "pref");
        DefaultFormBuilder builder = new DefaultFormBuilder(layout);
        builder.append("Username\t: ", new JTextField(20));
        return builder.getPanel();
    }
    
    private JComponent buildPreferredSizePanel() {
        FormLayout layout = new FormLayout(
                "right:max(25dlu;pref), 3dlu, default",
                "pref");
        DefaultFormBuilder builder = new DefaultFormBuilder(layout);
        builder.append("Username\t: ", new JPasswordField(20));
        return builder.getPanel();
    }
    
    private JComponent buildTextPanel() {
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        textArea.setMargin(new Insets(6, 10, 4, 6));
        textArea.setText("The text field used in the example on the left\n" +
        "has a narrow minimum width and a wider preferred width.\n\n" +
        "If you move the split divider to the left and right\n" +
        "you can see how 'Default' shrinks the field if space is scarce.\n\n" +
        "If there's not enough space for the preferred width\n" + 
        "the bottom field will be 'cut' on the right-hand side.");
        JScrollPane scrollpane = new JScrollPane(textArea);
        scrollpane.setBorder(new EmptyBorder(0, 0, 0, 0));
        return scrollpane;
    }

}
