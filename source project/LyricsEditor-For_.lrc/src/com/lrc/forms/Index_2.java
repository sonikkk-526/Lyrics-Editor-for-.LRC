package com.lrc.forms;

import com.lrc.events.EventSwitchSelected;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import com.lrc.componenet.Time_Modifier;

/*
class Index_2_Updates extends com.lrc.forms.Editor_Form {
    private final Index_2 TRIM = Index_2.getIndex_2Class();
    
    private void inputsKeyReleased(java.awt.event.KeyEvent evt) {                                   
        outputWriter();
        if (evt.getKeyChar() == KeyEvent.VK_CONTROL) { // why == not != ?
            TRIM.getInputs().setCaretPosition(0);
        }
        
        TRIM.trim_lyrics();
    }
}
*/

public class Index_2 extends javax.swing.JPanel {
    private final Time_Modifier EDITOR = new Time_Modifier();
    private boolean isIgnoreOn;
    
    public Index_2() {
        initComponents();
        outputs.setEditable(false);
        checkSkipInputs();
        
        ignore_switch.addEventSelected(new EventSwitchSelected() {
            @Override
            public void onSelected(boolean isOn) {
                isIgnoreOn = isOn;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headings = new javax.swing.JPanel();
        form_title = new javax.swing.JLabel();
        form_logo = new javax.swing.JLabel();
        input_prompt = new javax.swing.JLabel();
        output_prompt = new javax.swing.JLabel();
        ioPanel = new javax.swing.JPanel();
        textAreaScroll1 = new com.lrc.ui.TextAreaScroll();
        inputs = new com.lrc.ui.TextArea();
        textAreaScroll2 = new com.lrc.ui.TextAreaScroll();
        outputs = new com.lrc.ui.TextArea();
        jLabel1 = new javax.swing.JLabel();
        optionText = new javax.swing.JLabel();
        optionPanel = new javax.swing.JPanel();
        occurTextField = new com.lrc.ui.TextField();
        ms_text = new javax.swing.JLabel();
        skipPrompt_text = new javax.swing.JLabel();
        ignore_switch = new com.lrc.ui.SwitchButton();
        ignore_timestamp_text = new javax.swing.JLabel();

        setOpaque(false);

        headings.setOpaque(false);

        form_title.setFont(new java.awt.Font("Segoe UI Semilight", 1, 32)); // NOI18N
        form_title.setForeground(new java.awt.Color(163, 163, 163));
        form_title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        form_title.setText(" Lyrics Trimming");

        form_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lrc/icon/3.png"))); // NOI18N

        javax.swing.GroupLayout headingsLayout = new javax.swing.GroupLayout(headings);
        headings.setLayout(headingsLayout);
        headingsLayout.setHorizontalGroup(
            headingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headingsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(form_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(form_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headingsLayout.setVerticalGroup(
            headingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headingsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(headingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(form_logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(form_title, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 0, 0))
        );

        input_prompt.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        input_prompt.setForeground(new java.awt.Color(163, 163, 163));
        input_prompt.setText("Input:");

        output_prompt.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        output_prompt.setForeground(new java.awt.Color(163, 163, 163));
        output_prompt.setText("Output:");

        ioPanel.setOpaque(false);

        textAreaScroll1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        textAreaScroll1.setLabelText("Put your original lyrics here...");
        textAreaScroll1.setLineColor(new java.awt.Color(0, 204, 255));
        textAreaScroll1.setOpaque(false);

        inputs.setBackground(new java.awt.Color(43, 43, 43));
        inputs.setColumns(20);
        inputs.setForeground(new java.awt.Color(204, 204, 204));
        inputs.setRows(5);
        inputs.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        inputs.setOpaque(false);
        inputs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputsKeyReleased(evt);
            }
        });
        textAreaScroll1.setViewportView(inputs);

        textAreaScroll2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        textAreaScroll2.setLabelText("The result goes here...");
        textAreaScroll2.setLineColor(new java.awt.Color(255, 51, 102));
        textAreaScroll2.setOpaque(false);

        outputs.setBackground(new java.awt.Color(43, 43, 43));
        outputs.setColumns(20);
        outputs.setForeground(new java.awt.Color(204, 204, 204));
        outputs.setRows(5);
        outputs.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        outputs.setOpaque(false);
        textAreaScroll2.setViewportView(outputs);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lrc/icon/transfer.png"))); // NOI18N

        javax.swing.GroupLayout ioPanelLayout = new javax.swing.GroupLayout(ioPanel);
        ioPanel.setLayout(ioPanelLayout);
        ioPanelLayout.setHorizontalGroup(
            ioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ioPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textAreaScroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        ioPanelLayout.setVerticalGroup(
            ioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(textAreaScroll2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ioPanelLayout.createSequentialGroup()
                .addContainerGap(390, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(290, 290, 290))
        );

        optionText.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        optionText.setForeground(new java.awt.Color(163, 163, 163));
        optionText.setText("Options:");

        optionPanel.setOpaque(false);

        occurTextField.setBackground(new java.awt.Color(43, 43, 43));
        occurTextField.setForeground(new java.awt.Color(165, 165, 165));
        occurTextField.setText("0");
        occurTextField.setLabelText("Skip");
        occurTextField.setLineColor(new java.awt.Color(0, 204, 0));

        ms_text.setForeground(new java.awt.Color(165, 165, 165));
        ms_text.setText("lines");

        skipPrompt_text.setFont(new java.awt.Font("Segoe UI Semilight", 1, 20)); // NOI18N
        skipPrompt_text.setForeground(new java.awt.Color(165, 165, 165));
        skipPrompt_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        skipPrompt_text.setText("Number of Occurrence");

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addComponent(skipPrompt_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(occurTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ms_text))
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(occurTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(skipPrompt_text)
                    .addComponent(ms_text))
                .addContainerGap())
        );

        ignore_switch.setBackground(new java.awt.Color(0, 204, 204));

        ignore_timestamp_text.setFont(new java.awt.Font("Segoe UI Semilight", 1, 20)); // NOI18N
        ignore_timestamp_text.setForeground(new java.awt.Color(165, 165, 165));
        ignore_timestamp_text.setText("Ignore Timestamps");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(headings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(input_prompt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(output_prompt)
                                .addGap(515, 515, 515))
                            .addComponent(ioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(594, 594, 594)
                                .addComponent(optionText))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(276, 276, 276)
                                .addComponent(optionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(ignore_switch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ignore_timestamp_text)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(headings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_prompt)
                    .addComponent(output_prompt))
                .addGap(0, 0, 0)
                .addComponent(ioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ignore_timestamp_text)
                            .addComponent(ignore_switch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Return a String array of the inputs
     * @return String Array with the inputs
     */
    private ArrayList<String> readStringArrListLyrics() { // .removeAll(Arrays.asList("", null))
        ArrayList<String> result = new ArrayList<>(Arrays.asList(inputs.getText().trim().replace(System.getProperty("line.separator"), "\\n").split("\\n")));
        result.removeAll(Arrays.asList("", null));
        return result;
    }
    
    public void trim_lyrics() { // trim lyrics should be able to identify whether it contains lyrics or not
        String result = "";
        int skip_occur = Integer.parseInt(occurTextField.getText());
        
        for (int i = skip_occur; i < readStringArrListLyrics().size(); i++) {
            String currentLine = readStringArrListLyrics().get(i);
            result += String.format("%s%n", currentLine);
            
            if (skip_occur > readStringArrListLyrics().size()) {
                i += (skip_occur - readStringArrListLyrics().size());
            } else {
                i += skip_occur;
            }
        }
        
        outputs.setText(result);
    }
    
    /**
     * Checks whether input of the seconds text field
     * positive numbers only.
     */
    private void checkSkipInputs() {
        final int MAX_CHAR = 3;
        AbstractDocument textfield = (AbstractDocument) occurTextField.getDocument();
        textfield.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offs, int length, String str, AttributeSet a)
                    throws BadLocationException {
                String in = fb.getDocument().getText(0, fb.getDocument().getLength());
                in += str;
                if ((fb.getDocument().getLength() + str.length() - length) <= MAX_CHAR && (in.matches("^[0-9]{0,3}"))) {
                    super.replace(fb, offs, length, str, a);
                    trim_lyrics();
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }

            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offs, String str, AttributeSet a)
                    throws BadLocationException {
                String in = fb.getDocument().getText(0, fb.getDocument().getLength());
                in += str;
                if ((fb.getDocument().getLength() + str.length()) <= MAX_CHAR && (in.matches("^[0-9]{0,3}"))) {
                    super.insertString(fb, offs, str, a);
                    trim_lyrics();
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }

        });
    }
    
    
    /* Accessor Method */
    /**
     * Get a String array that contains all the merge lyrics.
     * @return String[] merge lyrics
     */
    public String[] getTrimmedOutputs() {
        return outputs.getText().split("\\n");
    }
    
    public boolean getIsIgnoreOn() {
        return isIgnoreOn;
    }
    
    /*
    public com.lrc.componenet.TextArea getInputs() {
        return inputs;
    }
    
    public Index_2 getIndex_2Class() {
        return this;
    }
    */
    
    private void inputsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputsKeyReleased
        if (evt.getKeyChar() == KeyEvent.VK_CONTROL) {
            inputs.setCaretPosition(0);
        }
        
        trim_lyrics();
    }//GEN-LAST:event_inputsKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel form_logo;
    private javax.swing.JLabel form_title;
    private javax.swing.JPanel headings;
    private com.lrc.ui.SwitchButton ignore_switch;
    private javax.swing.JLabel ignore_timestamp_text;
    private javax.swing.JLabel input_prompt;
    private com.lrc.ui.TextArea inputs;
    private javax.swing.JPanel ioPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel ms_text;
    private com.lrc.ui.TextField occurTextField;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JLabel optionText;
    private javax.swing.JLabel output_prompt;
    private com.lrc.ui.TextArea outputs;
    private javax.swing.JLabel skipPrompt_text;
    private com.lrc.ui.TextAreaScroll textAreaScroll1;
    private com.lrc.ui.TextAreaScroll textAreaScroll2;
    // End of variables declaration//GEN-END:variables
}
