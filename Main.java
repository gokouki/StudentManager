package ch12_151304064_151304094;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener{
	//��ʼ�����˵�
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuBar jMenuBar1=new JMenuBar();
	JMenu jMenu1=new JMenu("�˵�ѡ��");
	JMenuItem jMenuItem1=new JMenuItem("¼��ѧ��������Ϣ");
	JMenuItem jMenuItem2=new JMenuItem("ɾ��ѧ��������Ϣ");
	JMenuItem jMenuItem3=new JMenuItem("��ѯ���޸�ѧ��������Ϣ");
	JMenuItem jMenuItem4=new JMenuItem("���ȫ��ѧ��������Ϣ");
	JMenu jMenuFile=new JMenu("�����˳�");
	JMenuItem exit=new JMenuItem("ȷ���˳�");
	//���췽���������ʼ��
	
	public Main(){
		//����������壬�����䲼��
		JPanel contentPane=(JPanel)getContentPane();
		contentPane.setLayout(new BorderLayout());
		//��ܵĴ�С�������
		setSize(new Dimension(640,500));
		setTitle("ѧ������ϵͳ by ���ɻԺ�����");
		//��Ӳ˵���
		setJMenuBar(jMenuBar1);
		//��Ӳ˵�������˵���
		jMenuBar1.add(jMenu1);
		jMenuBar1.add(jMenuFile);
		//��Ӳ˵���������˵����
		jMenu1.add(jMenuItem1);
		jMenu1.add(jMenuItem2);
		jMenu1.add(jMenuItem3);
		jMenu1.add(jMenuItem4);
		jMenuFile.add(exit);
		//���˵�����¼�������
		jMenuItem1.addActionListener(this);
		jMenuItem2.addActionListener(this);
		jMenuItem3.addActionListener(this);
		jMenuItem4.addActionListener(this);
		exit.addActionListener(this);

		//�رտ�ܴ���ʱ��Ĭ���¼�����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		//�������˳����˵���
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
		// ���������棬��ʹ����������Ļ����
		Main frame=new Main();
		//��ȡ��Ļ�ߴ�
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		//��ȡ������Ĵ���ߴ�
		Dimension frameSize=frame.getSize();
		//�������洰�����
		if(frameSize.height>screenSize.height)
			frameSize.height=screenSize.height;
		if(frameSize.width>screenSize.width)
			frameSize.width=screenSize.width;
		frame.setLocation((screenSize.width-frameSize.width)/2, (screenSize.height-frameSize.height)/2);
		//frame.setResizable(false);
		frame.setVisible(true);
	}
	
}

