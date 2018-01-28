package ch12_151304064_151304094;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener{
	//初始化主菜单
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuBar jMenuBar1=new JMenuBar();
	JMenu jMenu1=new JMenu("菜单选项");
	JMenuItem jMenuItem1=new JMenuItem("录入学生基本信息");
	JMenuItem jMenuItem2=new JMenuItem("删除学生基本信息");
	JMenuItem jMenuItem3=new JMenuItem("查询和修改学生基本信息");
	JMenuItem jMenuItem4=new JMenuItem("浏览全部学生基本信息");
	JMenu jMenuFile=new JMenu("程序退出");
	JMenuItem exit=new JMenuItem("确认退出");
	//构造方法，界面初始化
	
	public Main(){
		//创建内容面板，设置其布局
		JPanel contentPane=(JPanel)getContentPane();
		contentPane.setLayout(new BorderLayout());
		//框架的大小和其标题
		setSize(new Dimension(640,500));
		setTitle("学籍管理系统 by 王巧辉和张珂");
		//添加菜单条
		setJMenuBar(jMenuBar1);
		//添加菜单组件到菜单条
		jMenuBar1.add(jMenu1);
		jMenuBar1.add(jMenuFile);
		//添加菜单项组件到菜单组件
		jMenu1.add(jMenuItem1);
		jMenu1.add(jMenuItem2);
		jMenu1.add(jMenuItem3);
		jMenu1.add(jMenuItem4);
		jMenuFile.add(exit);
		//给菜单添加事件监听器
		jMenuItem1.addActionListener(this);
		jMenuItem2.addActionListener(this);
		jMenuItem3.addActionListener(this);
		jMenuItem4.addActionListener(this);
		exit.addActionListener(this);

		//关闭框架窗口时的默认事件方法
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		//单击“退出”菜单项
				if(actionEvent.getSource()==exit){
					System.exit(0);
				}

				if(actionEvent.getSource()==jMenuItem1){
					AddStudentPanel list = new AddStudentPanel();
					this.remove(this.getContentPane());
					this.setContentPane(list);
					this.setVisible(true);
				}
				if(actionEvent.getSource()==jMenuItem2){
					DeleteStudentPanel list = new DeleteStudentPanel();
					this.remove(this.getContentPane());
					this.setContentPane(list);
					this.setVisible(true);
				}
				if(actionEvent.getSource()==jMenuItem3){
					UpdateStudentPanel list = new UpdateStudentPanel();
					this.remove(this.getContentPane());
					this.setContentPane(list);
					this.setVisible(true);
				}
				if(actionEvent.getSource()==jMenuItem4){
					ListStudent list = new ListStudent();
					this.remove(this.getContentPane());
					this.setContentPane(list);
					this.setVisible(true);
				}
		
	}
	public static void main(String[] args) {
		// 创建主界面，并使主窗口在屏幕居中
		Main frame=new Main();
		//获取屏幕尺寸
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		//获取主界面的窗体尺寸
		Dimension frameSize=frame.getSize();
		//令主界面窗体居中
		if(frameSize.height>screenSize.height)
			frameSize.height=screenSize.height;
		if(frameSize.width>screenSize.width)
			frameSize.width=screenSize.width;
		frame.setLocation((screenSize.width-frameSize.width)/2, (screenSize.height-frameSize.height)/2);
		//frame.setResizable(false);
		frame.setVisible(true);
	}
	
}

