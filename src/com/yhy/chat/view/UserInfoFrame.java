package com.yhy.chat.view;

import com.yhy.chat.main.ChatClient;
import com.yhy.chat.model.User;

import javax.swing.*;
import java.awt.*;
/**
 * @author: 杨海勇
 **/
public class UserInfoFrame extends JFrame {

	public static final int FRAME_WIDTH = 600;
	public static final int FRAME_HEIGHT = 500;

	private User user;

	public UserInfoFrame(User user) {
		super("<个人信息>");
		this.user = user;
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setIconImage(new ImageIcon(LoginFrame.class.getResource("/com/yhy/chat/view/assets/user.png")).getImage());
		this.setBackground(new Color(255, 255, 255));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		init();
		this.setVisible(true);
	}

	public void init() {
		if (user == null) {
			user = ChatClient.getInstance().getUser();
		}

		JTabbedPane tp = new JTabbedPane(JTabbedPane.TOP);
		this.add(tp, BorderLayout.CENTER);

		tp.addTab("基本信息", new UserInfoPanel(this));
		if (user.equals(ChatClient.getInstance().getUser())) {
			tp.addTab("修改密码", new PasswordPanel(this));
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
