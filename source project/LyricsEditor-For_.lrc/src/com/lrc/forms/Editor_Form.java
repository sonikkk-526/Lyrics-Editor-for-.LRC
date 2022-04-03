package com.lrc.forms;

import com.lrc.componenet.Time_Modifier;
import java.awt.Color;
import com.lrc.componenet.EventSwitchSelected;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Editor_Form extends javax.swing.JPanel {
    // instance and static variables
    private final Index_2 TRIM;
    private final Time_Modifier EDITOR = new Time_Modifier();
    private final Merge_Form MERGE;
    private static boolean isMergeOn, isTimeEditOn, isTagGenOn = false;
    
    
    // Constructor
    public Editor_Form(Merge_Form MERGE, Index_2 TRIM) {
        this.MERGE = MERGE;
        this.TRIM = TRIM;
        
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
        timeTextField.setEditable(false);
        merge_option1.setEnabled(false);
        outputs.setEditable(false);
        switches();
        
        MERGE.getMergeLyricsInputs().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputs.setCaretPosition(0);
                outputWriter();
            }
        });
        
        merge_option1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) { // if (e.getStateChange() == ItemEvent.SELECTED)
                outputWriter();
            }
        });
    }
    
    // Methods
    /**
     * Return a String array of the inputs
     * @return String Array with the inputs
     */
    private String[] readStringLyrics() {
        return inputs.getText().replace(System.getProperty("line.separator"), "\\n").split("\\n");
    }
    
    /**
     * Checks whether any switches are on or off and update the output.
     */
    private void switches() {
        merge_switch.addEventSelected(new EventSwitchSelected() {
            @Override
            public void onSelected(boolean isOn) {
                if (isOn) {
                    isMergeOn = true;
                    merge_option1.setEnabled(true);
                } else {
                    isMergeOn = false;
                    merge_option1.setEnabled(false);
                }
                outputWriter();
            }
        });
        
        time_switch.addEventSelected(new EventSwitchSelected() {
            @Override
            public void onSelected(boolean isOn) {
                if (isOn) { // use switch statement here
                    isTimeEditOn = true;
                    timeTextField.setEditable(true);
                    checkSecInputs();
                    outputWriter();
                } else {
                    isTimeEditOn = false;
                    timeTextField.setEditable(false);
                    outputWriter();
                }
            }
        });
        
        genHeader_switch.addEventSelected(new EventSwitchSelected() {
            @Override
            public void onSelected(boolean isOn) {
                isTagGenOn = isOn;
                outputWriter();
            }
        });
    }
    
    /**
     * Generate the outputs.
     * @return int Exit status: 0, EXIT_SUCCESS; -1, EXIT_FAILURE.
     */
    protected int outputWriter() {
        outputs.setForeground(new Color(204, 204, 204));
        
        // if input is empty, clear output screen
        if (isInputEmpty()) {
            return 0;
        }
        
        // check operation selected
        if (!isMergeOn && !isTimeEditOn && !isTagGenOn) {
            outputs.setText("No operation selected, console standby..");
            return 0;
        }
        
        String results = "";
        if (isTagGenOn) { // generate tags
            results += EDITOR.headerTag_gen();
        }
        
        if (isTimeEditOn || isMergeOn) { // generate results (timestamp editing)           
            int counter = 1;
            for (String line : readStringLyrics()) {
                // formatting timestamp for output
                String timestamp;
                try { // grab the timestamp
                    timestamp = EDITOR.extract_timestamp(line);
                } catch (NullPointerException nE) { // catch whether a timestamp is missing
                    outputs.setForeground(Color.RED);
                    outputs.setText(String.format("Missing timestamp: line %d.\n\nPlease check your inputs.", counter));
                    return -1;
                } catch (IllegalArgumentException iE) { // catch whether a timestamp is incorrect format
                    outputs.setForeground(Color.red);
                    outputs.setText(String.format("Incorrect timestamp formatting: line %d.\n\nPlease check your inputs.", counter));
                    return -1;
                }
                double seconds = (double) EDITOR.time2seconds(timestamp) + Double.parseDouble(timeTextField.getText());
                
                // determine whether timestamp should use original lyrics or merge lyrics
                if (isMergeOn) { // do some code optimization here later
                    if (merge_option1.isSelected()) {
                        String temp = EDITOR.getMergeLine(TRIM.getTrimmedOutputs(), counter-1);
                        try {
                            EDITOR.extract_timestamp(temp);

                            // if the above did not throw an exception (meaning: timestamp found)
                            outputs.setForeground(Color.RED);
                            outputs.setText("Check your Merge Lyrics.\n\nRemove timestamp or select \"Contains timestamp and remove\" option.");
                            return -1;
                        } catch (NullPointerException e) { // if there are no timestamp found (good for merging)
                            if (temp.equals("-1")) { // catch empty merge input here
                                outputs.setForeground(Color.RED);
                                outputs.setText("Missing Trimmed Merging Lyrics.\n\nPlease check your trimmed lyrics inputs.");
                                return -1;
                            }                        
                        }
                        
                        results += String.format("[%s]%s\n", EDITOR.seconds2time(seconds), temp);
                    } else {
                        String temp = EDITOR.getMergeLine(MERGE.getMergeLyrics(), counter-1);
                        
                        if (temp.equals("-1")) { // catch empty merge input here
                            outputs.setForeground(Color.RED);
                            outputs.setText("Missing Merge Lyrics.\n\nPlease check your merge lyrics inputs.");
                            return -1;
                        }
                        
                        results += String.format("[%s]%s\n", EDITOR.seconds2time(seconds), temp);
                    }
                } else { // use original lyrics line
                    results += String.format("[%s]%s\n", EDITOR.seconds2time(seconds), line.substring(line.indexOf("]")+1));
                }
                counter++;
            }
        } else {
            for (String line : readStringLyrics()) {
                results += String.format("%s%n", line);
            }
        }
        

        
        outputs.setText(results);
        outputs.setCaretPosition(0);
        return 0;
    }
    
    /**
     * Simply checks whether the input is empty
     * @return boolean Is the input empty
     */
    private boolean isInputEmpty() {
        if (inputs.getText().equals("")) {
            outputs.setText("");
            return true;            
        }
        
        return false;
    }
    
    /**
     * Checks whether input of the seconds text field
     * is (1) <= 8 (2) numbers and "." only (3) prefix == "-" or none
     */
    private void checkSecInputs() {
        final int MAX_CHAR = 8;
        AbstractDocument textfield = (AbstractDocument) timeTextField.getDocument();
        textfield.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a)
                    throws BadLocationException {
                String in = fb.getDocument().getText(0, fb.getDocument().getLength());
                in += str;
                if ((fb.getDocument().getLength() + str.length() - length) <= MAX_CHAR && (in.matches("^[0-9-]+[.]?[0-9]{0,2}$") 
                        || in.substring(0, 1).matches("-")) && !in.substring(1).contains("-")) {
                    super.replace(fb, offs, length, str, a);
                    outputWriter();
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }

            @Override
            public void insertString(FilterBypass fb, int offs, String str, AttributeSet a)
                    throws BadLocationException {
                String in = fb.getDocument().getText(0, fb.getDocument().getLength());
                in += str;
                if ((fb.getDocument().getLength() + str.length()) <= MAX_CHAR && (in.matches("^[0-9-]+[.]?[0-9]{0,2}$") 
                        || in.substring(0, 1).equals("-")) && !in.substring(1).contains("-")) {
                    super.insertString(fb, offs, str, a);
                    outputWriter();
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }

        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editorPanel = new javax.swing.JPanel();
        ioPanel = new javax.swing.JPanel();
        textAreaScroll1 = new com.lrc.componenet.TextAreaScroll();
        inputs = new com.lrc.componenet.TextArea();
        textAreaScroll2 = new com.lrc.componenet.TextAreaScroll();
        outputs = new com.lrc.componenet.TextArea();
        jLabel1 = new javax.swing.JLabel();
        optionPanel = new javax.swing.JPanel();
        mergePanel = new javax.swing.JPanel();
        merge_switch = new com.lrc.componenet.SwitchButton();
        merge_text = new javax.swing.JLabel();
        merge_option1 = new com.lrc.componenet.JCheckBoxCustom();
        timestampPanel = new javax.swing.JPanel();
        timeTextField = new com.lrc.componenet.TextField();
        ms_text = new javax.swing.JLabel();
        time_switch = new com.lrc.componenet.SwitchButton();
        timestamp_text = new javax.swing.JLabel();
        genPanel = new javax.swing.JPanel();
        genHeader_switch = new com.lrc.componenet.SwitchButton();
        genHeader_text = new javax.swing.JLabel();
        input_prompt = new javax.swing.JLabel();
        output_prompt = new javax.swing.JLabel();
        optionText = new javax.swing.JLabel();

        setOpaque(false);

        editorPanel.setOpaque(false);

        ioPanel.setOpaque(false);

        textAreaScroll1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        textAreaScroll1.setLabelText("Put your original lyrics here...");
        textAreaScroll1.setLineColor(new java.awt.Color(51, 255, 51));
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
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textAreaScroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ioPanelLayout.setVerticalGroup(
            ioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ioPanelLayout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ioPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(ioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textAreaScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addComponent(textAreaScroll2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        optionPanel.setOpaque(false);

        mergePanel.setOpaque(false);

        merge_switch.setBackground(new java.awt.Color(153, 0, 153));

        merge_text.setFont(new java.awt.Font("Segoe UI Semilight", 1, 20)); // NOI18N
        merge_text.setForeground(new java.awt.Color(165, 165, 165));
        merge_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        merge_text.setText("Merge");

        merge_option1.setBackground(new java.awt.Color(235, 52, 122));
        merge_option1.setForeground(new java.awt.Color(165, 165, 165));
        merge_option1.setText("Use Trimmed Lyrics");
        merge_option1.setFont(new java.awt.Font("Segoe UI Semilight", 3, 12)); // NOI18N

        javax.swing.GroupLayout mergePanelLayout = new javax.swing.GroupLayout(mergePanel);
        mergePanel.setLayout(mergePanelLayout);
        mergePanelLayout.setHorizontalGroup(
            mergePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mergePanelLayout.createSequentialGroup()
                .addComponent(merge_switch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(merge_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(merge_option1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mergePanelLayout.setVerticalGroup(
            mergePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mergePanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(mergePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mergePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(merge_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(merge_option1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mergePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(merge_switch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        timestampPanel.setOpaque(false);

        timeTextField.setBackground(new java.awt.Color(43, 43, 43));
        timeTextField.setForeground(new java.awt.Color(165, 165, 165));
        timeTextField.setText("0");
        timeTextField.setLabelText("Time");
        timeTextField.setLineColor(new java.awt.Color(0, 174, 255));

        ms_text.setForeground(new java.awt.Color(165, 165, 165));
        ms_text.setText("seconds");

        timestamp_text.setFont(new java.awt.Font("Segoe UI Semilight", 1, 20)); // NOI18N
        timestamp_text.setForeground(new java.awt.Color(165, 165, 165));
        timestamp_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timestamp_text.setText("Timestamp Edit");

        javax.swing.GroupLayout timestampPanelLayout = new javax.swing.GroupLayout(timestampPanel);
        timestampPanel.setLayout(timestampPanelLayout);
        timestampPanelLayout.setHorizontalGroup(
            timestampPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timestampPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(time_switch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timestamp_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ms_text)
                .addContainerGap())
        );
        timestampPanelLayout.setVerticalGroup(
            timestampPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timestampPanelLayout.createSequentialGroup()
                .addGroup(timestampPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(timestampPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(timestampPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ms_text)
                            .addComponent(timestamp_text)))
                    .addGroup(timestampPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(time_switch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        genPanel.setOpaque(false);

        genHeader_switch.setBackground(new java.awt.Color(150, 75, 0));

        genHeader_text.setFont(new java.awt.Font("Segoe UI Semilight", 1, 20)); // NOI18N
        genHeader_text.setForeground(new java.awt.Color(165, 165, 165));
        genHeader_text.setText("Auto-gen Header Tags");

        javax.swing.GroupLayout genPanelLayout = new javax.swing.GroupLayout(genPanel);
        genPanel.setLayout(genPanelLayout);
        genPanelLayout.setHorizontalGroup(
            genPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genPanelLayout.createSequentialGroup()
                .addComponent(genHeader_switch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(genHeader_text)
                .addContainerGap())
        );
        genPanelLayout.setVerticalGroup(
            genPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, genPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(genPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genHeader_text)
                    .addComponent(genHeader_switch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(mergePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(timestampPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(genPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(mergePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(timestampPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                .addComponent(genPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        input_prompt.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        input_prompt.setForeground(new java.awt.Color(163, 163, 163));
        input_prompt.setText("Input:");

        output_prompt.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        output_prompt.setForeground(new java.awt.Color(163, 163, 163));
        output_prompt.setText("Output:");

        optionText.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        optionText.setForeground(new java.awt.Color(163, 163, 163));
        optionText.setText("Options:");

        javax.swing.GroupLayout editorPanelLayout = new javax.swing.GroupLayout(editorPanel);
        editorPanel.setLayout(editorPanelLayout);
        editorPanelLayout.setHorizontalGroup(
            editorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(editorPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(input_prompt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 620, Short.MAX_VALUE)
                .addComponent(output_prompt)
                .addGap(521, 521, 521))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(optionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(editorPanelLayout.createSequentialGroup()
                .addGap(593, 593, 593)
                .addComponent(optionText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editorPanelLayout.setVerticalGroup(
            editorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editorPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(editorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_prompt)
                    .addComponent(output_prompt))
                .addGap(0, 0, 0)
                .addComponent(ioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(editorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputsKeyReleased
        outputWriter();
        
        if (evt.getKeyChar() == KeyEvent.VK_CONTROL) { // why == not != ?
            inputs.setCaretPosition(0);
        }
    }//GEN-LAST:event_inputsKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel editorPanel;
    private com.lrc.componenet.SwitchButton genHeader_switch;
    private javax.swing.JLabel genHeader_text;
    private javax.swing.JPanel genPanel;
    private javax.swing.JLabel input_prompt;
    private com.lrc.componenet.TextArea inputs;
    private javax.swing.JPanel ioPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mergePanel;
    private com.lrc.componenet.JCheckBoxCustom merge_option1;
    private com.lrc.componenet.SwitchButton merge_switch;
    private javax.swing.JLabel merge_text;
    private javax.swing.JLabel ms_text;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JLabel optionText;
    private javax.swing.JLabel output_prompt;
    private com.lrc.componenet.TextArea outputs;
    private com.lrc.componenet.TextAreaScroll textAreaScroll1;
    private com.lrc.componenet.TextAreaScroll textAreaScroll2;
    private com.lrc.componenet.TextField timeTextField;
    private com.lrc.componenet.SwitchButton time_switch;
    private javax.swing.JPanel timestampPanel;
    private javax.swing.JLabel timestamp_text;
    // End of variables declaration//GEN-END:variables
}
