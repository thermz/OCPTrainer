/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package me.ocptrain.operatorstrainer;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Optional.ofNullable;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Riccardo
 */
class Answer {
	private final boolean one, same, two;

	public Answer(boolean one, boolean same, boolean two) {
		if(Stream.of(one, same, two).filter(b -> b).count() != 1){
			throw new IllegalArgumentException("Only one option at the time is suitable");
		}
		this.one = one;
		this.same = same;
		this.two = two;
	}

	public boolean isOne() {
		return one;
	}

	public boolean isSame() {
		return same;
	}

	public boolean isTwo() {
		return two;
	}
	
}

class AnswerValidation{
	final boolean valid;
	final String message;

	public AnswerValidation(boolean valid, String message) {
		this.valid = valid;
		this.message = message;
	}

	public boolean isValid() {
		return valid;
	}

	public String getMessage() {
		return message;
	}
	
}

class OperatorTrainerListRenderer extends DefaultListCellRenderer {
	
	static final Color 
		DARK_GREEN = new Color(10, 110, 10),
		DARK_RED = new Color(200, 60, 60);
	
	@Override
    public Component getListCellRendererComponent(JList list, Object value, int index,
		boolean isSelected, boolean cellHasFocus) {
		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if ("OK".equals(value)) {
			setBackground(DARK_GREEN);
		} else if ("KO".equals(value)) {
			setBackground(DARK_RED);
		}
		if (isSelected) {
			setBackground(getBackground().darker());
		}
		return c;
	}
}

public class OperatorPrecedencePanel extends javax.swing.JPanel {

	private boolean isStarted = false;
	
	private Operators.OperatorInstance op1, op2;
	
	private List<AnswerValidation> attempts = new ArrayList<>();
	
	static final String HELP_TEXT = "<html>Click <b>Start</b> to run the test, only when you click <b>Stop</b> the test ends and summary statistics will be displayed at the bottom. "
		+ "<br/>Please remind that you can always double click on every attempt KO or OK to see the complete message</html>";
	
	/**
	 * Creates new form OperatorPrecedenceForm
	 */
	public OperatorPrecedencePanel() {
		initComponents();
		initAttemptsList();
		attemptsProgressBar.setMaximum(100);
		attemptsProgressBar.setStringPainted(true);
		attemptsProgressBar.setString("0%");
	}
	
	private void initAttemptsList(){
		outAttempts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList)evt.getSource();
				if (evt.getClickCount() == 2) {
					// Double-click detected
					int index = list.locationToIndex(evt.getPoint());
					var attempt = attempts.get(index);
					var prefix = VALIDATION_SHORT_MESSAGES.get(attempt.isValid());
					JOptionPane.showMessageDialog(OperatorPrecedencePanel.this, prefix+" "+attempt.getMessage());
				}
			}
		});
		outAttempts.setCellRenderer(new OperatorTrainerListRenderer());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        operator1F = new javax.swing.JTextField();
        operator2F = new javax.swing.JTextField();
        op2B = new javax.swing.JButton();
        op1B = new javax.swing.JButton();
        sameB = new javax.swing.JButton();
        startB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outAttempts = new javax.swing.JList<>();
        stopB = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        singleOutputTextF = new javax.swing.JScrollPane();
        outputComparisonTA = new javax.swing.JTextArea();
        helpB = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        attemptsCountF = new javax.swing.JTextField();
        attemptsProgressBar = new javax.swing.JProgressBar();

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Operator precedence trainer");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Operator 1");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Operator 2");

        operator1F.setEditable(false);

        operator2F.setEditable(false);

        op2B.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        op2B.setText("2");
        op2B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op2BActionPerformed(evt);
            }
        });

        op1B.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        op1B.setText("1");
        op1B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op1BActionPerformed(evt);
            }
        });

        sameB.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        sameB.setText("Same");
        sameB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sameBActionPerformed(evt);
            }
        });

        startB.setText("Start");
        startB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(outAttempts);

        stopB.setText("Stop");
        stopB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("<html>Which operator has<br/>more precedence?</html>");

        singleOutputTextF.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        singleOutputTextF.setEnabled(false);
        singleOutputTextF.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N

        outputComparisonTA.setEditable(false);
        outputComparisonTA.setColumns(20);
        outputComparisonTA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        outputComparisonTA.setLineWrap(true);
        outputComparisonTA.setRows(3);
        outputComparisonTA.setWrapStyleWord(true);
        outputComparisonTA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        singleOutputTextF.setViewportView(outputComparisonTA);

        helpB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button-question-mark-help.png"))); // NOI18N
        helpB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpBActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Final score summary");

        jLabel6.setText("Number of attempts: ");

        jLabel7.setText("Rate: ");

        attemptsCountF.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(op1B, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sameB, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(op2B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(operator1F, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(operator2F, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(singleOutputTextF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(startB, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(stopB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(helpB, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(attemptsCountF, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attemptsProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(helpB, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(stopB))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(operator1F, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(operator2F, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(op2B, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sameB, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(op1B, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(singleOutputTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attemptsCountF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(79, 79, 79))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(attemptsProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void startBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBActionPerformed
        isStarted = true;
		refreshOperators();
		clearSummaryStats();
    }//GEN-LAST:event_startBActionPerformed

    private void stopBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBActionPerformed
        isStarted = false;
		clear();
		setSummaryStats();
    }//GEN-LAST:event_stopBActionPerformed

    private void op1BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op1BActionPerformed
        Answer a = new Answer(true, false, false);
		submitOpCheckEvent(a);
    }//GEN-LAST:event_op1BActionPerformed

    private void sameBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sameBActionPerformed
        // TODO add your handling code here:
		Answer a = new Answer(false, true, false);
		submitOpCheckEvent(a);
    }//GEN-LAST:event_sameBActionPerformed

    private void op2BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op2BActionPerformed
        Answer a = new Answer(false, false, true);
		submitOpCheckEvent(a);
    }//GEN-LAST:event_op2BActionPerformed
	
    private void helpBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpBActionPerformed
        // TODO add your handling code here:
		JOptionPane.showMessageDialog(this, HELP_TEXT);
    }//GEN-LAST:event_helpBActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				var form = new OperatorPrecedencePanel();
//				form.setLocationRelativeTo(null);
				form.setVisible(true);
			}
		});
	}
	
	void clear(){
		operator1F.setText("");
		operator2F.setText("");
		outputComparisonTA.setText("");
//		outAttempts.setListData(new String[]{});
	}
	
	void refreshOperators(){
		op1 = Operators.getRandomInstance();
		op2 = Operators.getRandomInstance();
		
		operator1F.setText(op1.getOperator());
		operator2F.setText(op2.getOperator());
		
	}
	
	private static final Map<Integer, Function<Answer,Boolean>> VALIDATION_MAP = new HashMap<>(){{
		put(-1, Answer::isTwo);
		put(0, Answer::isSame);
		put(1, Answer::isOne);
	}};
	
	private static final Map<Integer, String> VALIDATION_COMPARISON_MESSAGE = new HashMap<>(){{
		put(-1, "Second operator {1} has more precedence than {0}");
		put(0, "The 2 operators {0},{1} have the same level of precedence");
		put(1, "First operator {0} has more precedence than {1}");
	}};
	
	private static final Map<Boolean, String> VALIDATION_MESSAGES = new HashMap<>(){{
		put(true, "Correct answer: ");
		put(false, "Wrong answer: ");
	}};
	
	private static final Map<Boolean, String> VALIDATION_SHORT_MESSAGES = new HashMap<>(){{
		put(true, "OK");
		put(false, "KO");
	}};
	
	
	private AnswerValidation createValidation(Answer a, int comparison){
		Boolean valid = ofNullable( VALIDATION_MAP.get(comparison) ).map( f -> f.apply(a) ).orElseThrow();
		String outputMessage = VALIDATION_MESSAGES.get(valid) + getValidationComparisonMessage(comparison);
		return new AnswerValidation(valid, outputMessage);
	}
	
	private String getValidationComparisonMessage(int comparison){
		return MessageFormat.format( VALIDATION_COMPARISON_MESSAGE.get(comparison), op1.getOperator(), op2.getOperator() );
	}
	
	void submitOpCheckEvent(Answer a){
		if(isStarted){
			AnswerValidation validation = createValidation(a, op1.compareTo(op2));
			outputComparisonTA.setText(validation.getMessage());
			addAttempt(validation);
			refreshOperators();
		} else {
			JOptionPane.showMessageDialog(this, "Please click start to run the test");
		}
	}
	
	//XXX --------- attempts JList should be strictly coupled to attempts array
	void addAttempt(AnswerValidation attempt){
		attempts.add(attempt);
		refreshOutputAttempts();
	}
	void clearAttempts(){
		attempts.clear();
		refreshOutputAttempts();
	}
	// ----------------------------------------------------------
	
	private void refreshOutputAttempts() {
		List<String> toRefresh = attempts.stream().map(AnswerValidation::isValid).map(VALIDATION_SHORT_MESSAGES::get).collect(Collectors.toList());
		outAttempts.setListData(toRefresh.toArray(String[]::new));
	}
	
	private void setSummaryStats() {
		attemptsCountF.setText(String.valueOf(attempts.size()));
		BigDecimal size = ( ! attempts.isEmpty() )?BigDecimal.valueOf(attempts.size()):BigDecimal.ONE;
		BigDecimal rate = BigDecimal.valueOf( attempts.stream().filter(AnswerValidation::isValid).count() )
			.divide(size, 2, RoundingMode.HALF_EVEN)
			.multiply(BigDecimal.valueOf(100));
		String rateperc = NumberFormat.getNumberInstance().format(rate.doubleValue());
		attemptsProgressBar.setString(rateperc+"%");
		attemptsProgressBar.setValue(rate.intValue());
	}
	
	private void clearSummaryStats() {
		attemptsProgressBar.setString("0%");
		attemptsCountF.setText("");
		attemptsProgressBar.setValue(0);
		clearAttempts();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField attemptsCountF;
    private javax.swing.JProgressBar attemptsProgressBar;
    private javax.swing.JButton helpB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton op1B;
    private javax.swing.JButton op2B;
    private javax.swing.JTextField operator1F;
    private javax.swing.JTextField operator2F;
    private javax.swing.JList<String> outAttempts;
    private javax.swing.JTextArea outputComparisonTA;
    private javax.swing.JButton sameB;
    private javax.swing.JScrollPane singleOutputTextF;
    private javax.swing.JButton startB;
    private javax.swing.JButton stopB;
    // End of variables declaration//GEN-END:variables


}