package Util;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class ConnectorListData implements Serializable{ // 접속자 리스트 정보를 가지는 클래스
	private static final long serialVersionUID = -5090007110618723237L;
	private String clientName;
	private ImageIcon icon;
	public ConnectorListData(String name, ImageIcon icon){
		this.clientName = name;
		this.icon = icon;
	}
	public String getClientName() { return clientName; }
	public ImageIcon getIcon() { return icon; }
}