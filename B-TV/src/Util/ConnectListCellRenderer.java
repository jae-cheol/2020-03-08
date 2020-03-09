package Util;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

public class ConnectListCellRenderer extends DefaultListCellRenderer {
	private static final long serialVersionUID = -3709995694570816438L;
	public Component getListCellRendererComponent(JList<?> list, Object val,
			int idx, boolean isSelected, boolean hasFocus) {
		JLabel comp = null;
		String txt = null;
		if (val instanceof ConnectorListData) {
			ConnectorListData data = (ConnectorListData) val;

			txt = data.getClientName();
			comp = (JLabel) super.getListCellRendererComponent(list, txt, idx, false, false);
			comp.setIcon(data.getIcon());
		}
		return comp;
	}
}
