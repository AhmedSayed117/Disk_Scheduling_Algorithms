import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame{
    private JPanel MainPanel;
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

    public GUI(String title){
        super(title);

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
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JRadioButton Radio : Array ) {
                    ArrayList<Integer> queue = new ArrayList<>();
                    queue.add(82);
                    queue.add(170);
                    queue.add(43);
                    queue.add(140);
                    queue.add(24);
                    queue.add(16);
                    queue.add(190);

                    if (Radio.isSelected()){
                        switch (Radio.getText()){
                            case "C-LOOK":
                            {
//                                C_LOOK obj = new C_LOOK(0,199,,queue);
//                                obj.Calculate();
//                                obj.display();
                                break;
                            }
                            case "LOOK":
                            {
                                LOOK obj;
                                if (CheckLook.getModel().getSelectedItem()=="Right"){
                                    obj = new LOOK(Integer.parseInt(StartC.getText()),Integer.parseInt(EndC.getText()),Integer.parseInt(FieldLook.getText()),true,queue);
                                }else {
                                    obj = new LOOK(Integer.parseInt(StartC.getText()),Integer.parseInt(EndC.getText()),Integer.parseInt(FieldLook.getText()),false,queue);
                                }
                                obj.Calculate();
                                obj.display();
                                break;
                            }
                            case "Scan":
                            {
                                SCAN obj;
                                if (CheckLook.getModel().getSelectedItem()=="Right"){
                                    obj = new SCAN(Integer.parseInt(StartC.getText()),Integer.parseInt(EndC.getText()),Integer.parseInt(FieldLook.getText()),true,queue);
                                }else {
                                    obj = new SCAN(Integer.parseInt(StartC.getText()),Integer.parseInt(EndC.getText()),Integer.parseInt(FieldLook.getText()),false,queue);
                                }
                                obj.Calculate();
                                obj.display();
                                break;
                            }
                            case "C-Scan":
                            {
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
                                OPTIMIZED obj = new OPTIMIZED(Integer.parseInt(StartC.getText()),Integer.parseInt(EndC.getText()),queue);
                                obj.Calculate();
                                obj.display();
                                break;
                            } default: break;
                        }
                    }
                }
            }
        });
    }
    public static void main(String[]args){
        JFrame j = new GUI("Disk Scheduling Algorithms");
        j.setVisible(true);
    }
}