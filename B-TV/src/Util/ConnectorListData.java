package Util;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class ConnectorListData implements Serializable{ // ������ ����Ʈ ������ ������ Ŭ����
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