package com.lrc.menu;

import com.lrc.events.EventMenuSelected;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class List_Menu<E extends Object> extends JList<E> {
    // instance variables
    private final DefaultListModel MODEL;
    private int selectedIndex = -1;
    private int overIndex = -1;
    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
    }
    
    // Constructor
    public List_Menu() {
        MODEL = new DefaultListModel();
        setModel(MODEL);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent client) {
                if (SwingUtilities.isLeftMouseButton(client)) {
                    int index = locationToIndex(client.getPoint());
                    Object obj = MODEL.getElementAt(index);
                    if (obj instanceof Model_Menu) {
                        Model_Menu menu = (Model_Menu) obj;
                        if (menu.getType() == Model_Menu.MenuType.MENU) {
                            selectedIndex = index;
                            if (event != null) {
                                event.selected(index);
                            }
                        }
                    } else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                overIndex = -1;
                repaint();
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent client) {
                int index = locationToIndex(client.getPoint());
                if (index != overIndex) {
                    Object obj = MODEL.getElementAt(index);
                    if (obj instanceof Model_Menu) {
                        Model_Menu menu = (Model_Menu) obj;
                        if (menu.getType() == Model_Menu.MenuType.MENU) {
                            overIndex = index;
                        } else {
                            overIndex = -1;
                        }
                        repaint();
                    }
                }
            }

            public void mouseExited(MouseEvent me) {
                overIndex = -1;
                repaint();
            }
        });
    }
    
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object obj, int index, boolean selected, boolean focus) {
                Model_Menu data;
                if (obj instanceof Model_Menu) {
                    data = (Model_Menu) obj;
                } else {
                    data = new Model_Menu("", obj + "", Model_Menu.MenuType.EMPTY);
                }
                Menu_Item item = new Menu_Item(data);
                item.setSelected(selectedIndex == index);
                item.setHover(overIndex == index);
                return item;
            }

        };
    }
    
    public void addItem(Model_Menu data) {
        MODEL.addElement(data);
    }
}