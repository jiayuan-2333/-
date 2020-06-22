package 教务管理系统;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class LoginJFrame extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public LoginJFrame() {

        setTitle("学生登录");
        setBounds(300, 200, 300, 200);
        Container cp = getContentPane();
        cp.setLayout(null);
        JLabel jl = new JLabel("用户名：");
        jl.setBounds(10, 10, 200, 18);
        final JTextField name = new JTextField();
        name.setBounds(80, 10, 150, 18);
        JLabel jl2 = new JLabel("密码：");
        jl2.setBounds(10, 50, 200, 18);
        final JPasswordField password = new JPasswordField();
        password.setBounds(80, 50, 150, 18);
        cp.add(jl);
        cp.add(name);
        cp.add(jl2);
        cp.add(password);
        JButton jb = new JButton("确定");
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	Connection con = jdbc.getConnection("root","520");
                if (name.getText().trim().length() == 0
                        || new String(password.getPassword()).trim()
                                .length() == 0) {
                    JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
                    return;
                }else {
                	String youPassword = String.valueOf(password.getPassword());
                	String youName = name.getText();

                	try {
    					boolean yz = jdbc.checkLogin(youName, youPassword);;
    					 if (yz == false) {
    		                    JOptionPane.showMessageDialog(null, "用户名或密码错误");
    		                } else{
    		                    JOptionPane.showMessageDialog(null, "登录成功");
    		                	setVisible(false);
    		                	new StudentJFrame(youPassword);
    		                } 
    				} catch (SQLException e) {
    					// TODO 自动生成的 catch 块
    					e.printStackTrace();
    				}
              } 
               jdbc.releaseConnectin(con); 
            }
        });
        jb.setBounds(80, 80, 60, 18);
        cp.add(jb);

        final JButton button = new JButton();
        button.setText("重置");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // TODO 自动生成方法存根
                name.setText("");
                password.setText("");
            }
        });
        button.setBounds(150, 80, 60, 18);
        getContentPane().add(button);
        JButton Adminjb = new JButton("管理员登录");
        Adminjb .setBounds(30, 110, 100, 18);
        cp.add(Adminjb);
        Adminjb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                new AdminLogin();
            }
        });
        
        JButton Teacherjb = new JButton("教师登录");
        Teacherjb.setBounds(140, 110, 100, 18);
        cp.add(Teacherjb);
        Teacherjb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
                new TeacherLogin();
            }
        });

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        
    }

    public static void main(String[] args) {
        new LoginJFrame();
    }

}


