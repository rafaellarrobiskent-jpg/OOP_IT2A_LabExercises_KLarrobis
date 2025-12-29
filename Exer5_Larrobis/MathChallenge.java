import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

enum Difficulty {
    EASY(1, 100),
    MEDIUM(101, 500),
    HARD(501, 1000);

    private final int min, max;
    Difficulty(int min, int max) {
        this.min = min;
        this.max = max;
    }
    public int min() { return min; }
    public int max() { return max; }
    public String label() { return min + "-" + max; }
}

class ProblemMaker {
    private final Random rng = new Random();
    private int a, b, answer;
    private String sign = "+";

    public void create(String op, Difficulty diff) {
        sign = op;
        int min = diff.min(), max = diff.max();
        switch (op) {
            case "+": a = rand(min, max); b = rand(min, max); answer = a + b; break;
            case "-": a = rand(min, max); b = rand(min, max); if (b > a) { int t = a; a = b; b = t; } answer = a - b; break;
            case "*": a = rand(min, max); b = rand(min, max); answer = a * b; break;
            case "/": b = rand(1, max); int q = rand(1, max / b); a = b * q; answer = a / b; break;
            case "%": b = rand(1, max); a = rand(min, max); answer = a % b; break;
        }
    }

    private int rand(int min, int max) { return rng.nextInt(max - min + 1) + min; }
    public int getA() { return a; }
    public int getB() { return b; }
    public String getSign() { return sign; }
    public int getAnswer() { return answer; }
}

public class MathChallenge extends JFrame implements ActionListener {
    private static final Color BG = new Color(246, 248, 252);
    private static final Color PANEL = Color.WHITE;
    private static final Font HEAD = new Font("Segoe UI", Font.BOLD, 26);
    private static final Font TEXT = new Font("Segoe UI", Font.PLAIN, 16);

    private final ProblemMaker maker = new ProblemMaker();
    private String currentOp = "+";
    private Difficulty currentDiff = Difficulty.EASY;

    private final JTextField input = new JTextField(10);
    private final JButton btnSubmit = new JButton("SUBMIT");
    private final JButton btnNext = new JButton("CONTINUE");
    private final JButton btnExit = new JButton("EXIT");

    private final JLabel lblRight = new JLabel("0", SwingConstants.CENTER);
    private final JLabel lblWrong = new JLabel("0", SwingConstants.CENTER);

    private final JLabel lblA = new JLabel("0", SwingConstants.CENTER);
    private final JLabel lblB = new JLabel("0", SwingConstants.CENTER);
    private final JLabel lblSign = new JLabel("+", SwingConstants.CENTER);

    private final JLabel lblFeedback = new JLabel(" ", SwingConstants.LEFT);

    private int scoreR = 0, scoreW = 0;

    public MathChallenge() {
        installLaf();
        setTitle("Arithmetic Practice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(BG);
        setLayout(new BorderLayout(8, 8));
        add(makeUI(), BorderLayout.CENTER);

        btnSubmit.addActionListener(this);
        btnNext.addActionListener(this);
        btnExit.addActionListener(this);

        stylize(btnSubmit, new Color(53, 132, 228));
        stylize(btnNext, new Color(34, 197, 94));
        stylize(btnExit, new Color(239, 68, 68));

        btnNext.setEnabled(false);
        generateProblem();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel makeUI() {
        JPanel panel = new JPanel();
        panel.setBackground(BG);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Sharpen Your Math Skills!", SwingConstants.CENTER);
        title.setFont(HEAD);
        title.setForeground(new Color(40, 40, 60));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);
        panel.add(Box.createVerticalStrut(20));

        // Question
        JPanel questionRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        questionRow.setBackground(BG);
        Font fBig = new Font("Consolas", Font.BOLD, 46);
        Dimension size = new Dimension(130, 80);

        setup(lblA, fBig, size);
        setup(lblSign, fBig, new Dimension(80, 80));
        setup(lblB, fBig, size);

        JLabel eq = new JLabel("=", SwingConstants.CENTER);
        eq.setFont(fBig);
        eq.setPreferredSize(new Dimension(60, 80));

        input.setFont(fBig);
        input.setHorizontalAlignment(SwingConstants.CENTER);
        input.setPreferredSize(size);

        questionRow.add(lblA);
        questionRow.add(lblSign);
        questionRow.add(lblB);
        questionRow.add(eq);
        questionRow.add(input);
        panel.add(questionRow);
        panel.add(Box.createVerticalStrut(10));

        // Feedback and buttons
        JPanel feedback = new JPanel(new BorderLayout(15, 0));
        feedback.setBackground(BG);

        lblFeedback.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblFeedback.setForeground(new Color(40, 40, 60));
        feedback.add(lblFeedback, BorderLayout.WEST);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        buttons.setOpaque(false);

        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        top.setOpaque(false);
        top.add(btnSubmit);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        bottom.setOpaque(false);
        bottom.add(btnNext);
        bottom.add(btnExit);

        buttons.add(top);
        buttons.add(Box.createVerticalStrut(5));
        buttons.add(bottom);

        feedback.add(buttons, BorderLayout.EAST);
        panel.add(feedback);
        panel.add(Box.createVerticalStrut(25));

        // Bottom section
        JPanel bottomRow = new JPanel(new BorderLayout(15, 0));
        bottomRow.setBackground(BG);

        bottomRow.add(makeControls(), BorderLayout.WEST);
        bottomRow.add(makeScores(), BorderLayout.EAST);

        panel.add(bottomRow);
        return panel;
    }

    private JPanel makeControls() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        p.setBackground(BG);

        // Operations
        JPanel opPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        opPanel.setBackground(PANEL);
        opPanel.setBorder(BorderFactory.createTitledBorder("OPERATIONS"));
        ButtonGroup ops = new ButtonGroup();
        String[] signs = {"+", "-", "*", "/", "%"};
        String[] names = {"ADD (+)", "SUB (-)", "MULTI (*)", "DIV (/)", "MOD (%)"};
        for (int i = 0; i < signs.length; i++) {
            JRadioButton rb = new JRadioButton(names[i]);
            rb.setActionCommand(signs[i]);
            rb.setBackground(PANEL);
            rb.setFont(TEXT);
            rb.addActionListener(this::handleSelect);
            if (signs[i].equals(currentOp)) rb.setSelected(true);
            ops.add(rb);
            opPanel.add(rb);
        }

        // Difficulty
        JPanel lvlPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        lvlPanel.setBackground(PANEL);
        lvlPanel.setBorder(BorderFactory.createTitledBorder("LEVELS"));
        ButtonGroup lvls = new ButtonGroup();
        for (Difficulty d : Difficulty.values()) {
            JRadioButton rb = new JRadioButton(d.name() + " (" + d.label() + ")");
            rb.setActionCommand(d.name());
            rb.setBackground(PANEL);
            rb.setFont(TEXT);
            rb.addActionListener(this::handleSelect);
            if (d == currentDiff) rb.setSelected(true);
            lvls.add(rb);
            lvlPanel.add(rb);
        }

        p.add(opPanel);
        p.add(lvlPanel);
        return p;
    }

    private JPanel makeScores() {
        JPanel right = new JPanel();
        right.setBackground(BG);
        right.setLayout(new GridLayout(1, 2, 20, 0));

        right.add(makeBox(lblRight, "CORRECT", new Color(34, 197, 94)));
        right.add(makeBox(lblWrong, "INCORRECT", new Color(239, 68, 68)));
        return right;
    }

    private JPanel makeBox(JLabel label, String text, Color color) {
        JPanel box = new JPanel();
        box.setBackground(BG);
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));

        label.setFont(new Font("Segoe UI", Font.BOLD, 40));
        label.setForeground(color);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel caption = new JLabel(text, SwingConstants.CENTER);
        caption.setFont(new Font("Segoe UI", Font.BOLD, 16));
        caption.setAlignmentX(Component.CENTER_ALIGNMENT);
        caption.setForeground(new Color(40, 40, 60));

        box.add(label);
        box.add(Box.createVerticalStrut(5));
        box.add(caption);
        return box;
    }

    private void handleSelect(ActionEvent e) {
        String cmd = e.getActionCommand();
        if ("+-*/%".contains(cmd)) currentOp = cmd;
        else currentDiff = Difficulty.valueOf(cmd);
        lblSign.setText(currentOp);
        generateProblem();
    }

    private void generateProblem() {
        maker.create(currentOp, currentDiff);
        lblA.setText(String.valueOf(maker.getA()));
        lblB.setText(String.valueOf(maker.getB()));
        lblSign.setText(maker.getSign());
        input.setText("");
        input.setEnabled(true);
        btnSubmit.setEnabled(true);
        btnNext.setEnabled(false);
        lblFeedback.setText(" ");
        input.requestFocusInWindow();
    }

    private void checkAnswer() {
        try {
            int val = Integer.parseInt(input.getText().trim());
            boolean correct = val == maker.getAnswer();
            if (correct) {
                scoreR++;
                lblFeedback.setText("Nice! That’s correct!");
                lblFeedback.setForeground(new Color(34, 197, 94));
                lblRight.setText(String.valueOf(scoreR));
            } else {
                scoreW++;
                lblFeedback.setText("Oops! Correct answer: " + maker.getAnswer());
                lblFeedback.setForeground(new Color(239, 68, 68));
                lblWrong.setText(String.valueOf(scoreW));
            }
            input.setEnabled(false);
            btnSubmit.setEnabled(false);
            btnNext.setEnabled(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please type a valid number.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void stylize(JButton btn, Color bg) {
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void setup(JLabel lbl, Font f, Dimension d) {
        lbl.setFont(f);
        lbl.setOpaque(true);
        lbl.setBackground(PANEL);
        lbl.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210), 2));
        lbl.setPreferredSize(d);
    }

    private static void installLaf() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnSubmit) checkAnswer();
        else if (src == btnNext) generateProblem();
        else if (src == btnExit) {
            lblFeedback.setText("Game paused. Click CONTINUE for a new problem.");
            lblFeedback.setForeground(new Color(40, 40, 60));
            input.setEnabled(false);
            btnSubmit.setEnabled(false);
            btnNext.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MathChallenge::new);
    }
}
