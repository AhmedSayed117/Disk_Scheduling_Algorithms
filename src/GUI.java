import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame {
    private JPanel MainPanel;
    public String Text;
    private JLabel FirstLabel;
    private JPanel SecondPanel;
    private JRadioButton C_LOOK;
    private JRadioButton LOOK;
    private JRadioButton Scan;
    private JRadioButton C_Scan;
    private JRadioButton FCFS;
    private JRadioButton SSTF;
    private JRadioButton OPTIMIZED;
    private JButton CalculateButton;
    private JComboBox CheckC_Scan;
    private JComboBox CheckC_Look;
    private JComboBox CheckLook;
    private JComboBox CheckScan;
    private JFormattedTextField FieldC_Look;
    private JFormattedTextField FieldScan;
    private JFormattedTextField FieldC_Scan;
    private JFormattedTextField FieldFCFS;
    private JFormattedTextField FieldSSTF;
    private JTextField FieldLook;
    private JFormattedTextField StartC;
    private JFormattedTextField EndC;
    private JTextArea Que;

    public GUI(String title)
    {
        super(title);
        Que.setRows(10);

        ArrayList<JRadioButton> Array = new ArrayList<>();
        Array.add(C_LOOK);
        Array.add(LOOK);
        Array.add(Scan);
        Array.add(C_Scan);
        Array.add(FCFS);
        Array.add(SSTF);
        Array.add(OPTIMIZED);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(MainPanel);
        this.pack();

        CalculateButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e)
            {
                Text = Que.getText();
                String[] s = Text.split("\n");
                for (JRadioButton Radio : Array)
                {
                    ArrayList<Integer> queue = new ArrayList<>();
                    for (String value : s)
                        queue.add(Integer.parseInt(value));

                    if (Radio.isSelected())
                    {
                        switch (Radio.getText())
                        {
                            case "C-LOOK":
                            {
                                if (!FieldC_Look.getText().equals(""))
                                {
                                    C_LOOK obj;
                                    if (CheckC_Look.getModel().getSelectedItem() == "Right")
                                    {
                                        obj = new C_LOOK(Integer.parseInt(StartC.getText()), Integer.parseInt(EndC.getText()), Integer.parseInt(FieldC_Look.getText()), true, queue);
                                    }
                                    else
                                    {
                                        obj = new C_LOOK(Integer.parseInt(StartC.getText()), Integer.parseInt(EndC.getText()), Integer.parseInt(FieldC_Look.getText()), false, queue);
                                    }
                                    obj.Calculate();
                                    obj.display();
                                }
                                break;
                            }
                            case "LOOK":
                            {
                                if (!FieldLook.getText().equals(""))
                                {
                                    LOOK obj;
                                    if (CheckLook.getModel().getSelectedItem() == "Right")
                                    {
                                        obj = new LOOK(Integer.parseInt(StartC.getText()), Integer.parseInt(EndC.getText()), Integer.parseInt(FieldLook.getText()), true, queue);
                                    }
                                    else
                                    {
                                        obj = new LOOK(Integer.parseInt(StartC.getText()), Integer.parseInt(EndC.getText()), Integer.parseInt(FieldLook.getText()), false, queue);
                                    }
                                    obj.Calculate();
                                    obj.display();
                                }
                                break;
                            }
                            case "Scan":
                            {
                                if (!FieldScan.getText().equals(""))
                                {
                                    SCAN obj;
                                    if (CheckScan.getModel().getSelectedItem() == "Right")
                                    {
                                        obj = new SCAN(Integer.parseInt(StartC.getText()), Integer.parseInt(EndC.getText()), Integer.parseInt(FieldScan.getText()), true, queue);
                                    }
                                    else
                                    {
                                        obj = new SCAN(Integer.parseInt(StartC.getText()), Integer.parseInt(EndC.getText()), Integer.parseInt(FieldScan.getText()), false, queue);
                                    }
                                    obj.Calculate();
                                    obj.display();
                                }
                                break;
                            }
                            case "C-Scan":
                            {
                                if (!FieldC_Scan.getText().equals(""))
                                {
                                    C_SCAN obj;
                                    if (CheckC_Scan.getModel().getSelectedItem() == "Right")
                                    {
                                        obj = new C_SCAN(Integer.parseInt(StartC.getText()), Integer.parseInt(EndC.getText()), Integer.parseInt(FieldC_Scan.getText()), true, queue);
                                    }
                                    else
                                    {
                                        obj = new C_SCAN(Integer.parseInt(StartC.getText()), Integer.parseInt(EndC.getText()), Integer.parseInt(FieldC_Scan.getText()), false, queue);
                                    }
                                    obj.Calculate();
                                    obj.display();
                                }
                                break;
                            }
                            case "FCFS":
                            {
                                break;
                            }
                            case "SSTF":
                            {
                                break;
                            }
                            case "OPTIMIZED":
                            {
                                OPTIMIZED obj = new OPTIMIZED(Integer.parseInt(StartC.getText()), Integer.parseInt(EndC.getText()), queue);
                                obj.Calculate();
                                obj.display();
                                break;
                            }
                            default:
                                break;
                        }
                    }
                }
            }
        });
    }
    public static void main(String[] args)
    {
        JFrame j = new GUI("Disk Scheduling Algorithms");
        j.setVisible(true);
    }
}