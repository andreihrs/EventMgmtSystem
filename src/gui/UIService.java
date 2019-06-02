package gui;

import com.fmi.project.client.Client;
import com.fmi.project.location.Location;
import com.fmi.project.services.Service;
import com.fmi.project.services.ServiceAgencyDB;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UIService {

    private JPanel mainPanel;
    private JPanel Find;
    private JTable userTable;
    private JButton clientsWhoGoToEventsAfterSummer;
    private JButton clientsWhoSpentMoreThan100;
    private JButton firstTimeCustomers;
    private JButton clientsWhoGoToFreeEvents;
    private JButton locationsWhichAreFull;
    private JButton findClientsButton;
    private JTextField editText;
    private JLabel firstTimeCustomer;
    private JLabel pricePaid;
    private JLabel emailList;
    private JLabel noBookings;
    private JLabel companyName;
    private JTextField textFieldPricePaid;
    private JTextField textFieldNoOfBookings;
    private JButton UPDATEAgencyButton;
    private JButton INSERTAgencyButton;
    private JTextField textFieldEmailList;
    private JTextField textFieldFirstTimeCustomer;
    private JTextField textFieldCompanyName;
    private JButton DELETEAgencyButton;
    private JButton SELECTAgencyButton;
    private JPanel dbStorage;
    private JScrollPane mainJScrollPane1;
    private JTabbedPane tabbedPane;
    private JTextField textFieldId;

    public UIService() {
        firstTimeCustomers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<List<Client>, String> stringSwingWorker = new SwingWorker<List<Client>, String>() {
                    @Override
                    protected List<Client> doInBackground() throws Exception {

                        return Service.getInstance().firstTimeCustomers();
                    }

                    @Override
                    protected void done() {

                        try {
                            List<Client> result = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };

                                    defaultTableModel.addColumn("Price Paid");
                                    defaultTableModel.addColumn("First Time Customer");
                                    defaultTableModel.addColumn("Email List Subscription");

                                    for (Client client : result) {
                                        defaultTableModel.addRow(new Object[]{
                                                client.getPricePaid(), client.isFirstTimeCustomer(),
                                                client.getEmailListSubscription() });
                                    }

                                    userTable.setModel(defaultTableModel);
                                }
                            });

                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }
                    }
                };
                stringSwingWorker.execute();
            }
        });

        clientsWhoGoToFreeEvents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<List<Client>, String> stringSwingWorker = new SwingWorker<List<Client>, String>() {
                    @Override
                    protected List<Client> doInBackground() throws Exception {

                        return Service.getInstance().clientsWhoGoToFreeEvents();
                    }

                    @Override
                    protected void done() {

                        try {
                            List<Client> result = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };

                                    defaultTableModel.addColumn("Price Paid");
                                    defaultTableModel.addColumn("First Time Customer");
                                    defaultTableModel.addColumn("Email List Subscription");

                                    for (Client client : result) {
                                        defaultTableModel.addRow(new Object[]{client.getPricePaid(),
                                                  client.isFirstTimeCustomer(),
                                                  client.getEmailListSubscription() });
                                    }

                                    userTable.setModel(defaultTableModel);
                                }
                            });


                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }

                    }
                };

                stringSwingWorker.execute();

            }
        });

        clientsWhoGoToEventsAfterSummer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<List<Client>, String> stringSwingWorker = new SwingWorker<List<Client>, String>() {
                    @Override
                    protected List<Client> doInBackground() throws Exception {

                        return Service.getInstance().clientsWhoGoToEventsAfterSummer();
                    }

                    @Override
                    protected void done() {

                        try {
                            List<Client> result = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };

                                    defaultTableModel.addColumn("Price Paid");
                                    defaultTableModel.addColumn("First Time Customer");
                                    defaultTableModel.addColumn("Email List");

                                    for (Client client : result) {
                                        defaultTableModel.addRow(new Object[]{client.getPricePaid(),
                                                  client.isFirstTimeCustomer(),
                                                  client.getEmailListSubscription() });
                                    }

                                    userTable.setModel(defaultTableModel);
                                }
                            });


                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }

                    }
                };
                stringSwingWorker.execute();
            }
        });

        clientsWhoSpentMoreThan100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<List<Client>, String> stringSwingWorker = new SwingWorker<List<Client>, String>() {
                    @Override
                    protected List<Client> doInBackground() throws Exception {

                        return Service.getInstance().clientsWhoSpentMoreThan100();
                    }

                    @Override
                    protected void done() {

                        try {
                            List<Client> result = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };

                                    defaultTableModel.addColumn("Price Paid");
                                    defaultTableModel.addColumn("First Time Customer");
                                    defaultTableModel.addColumn("Email List");


                                    for (Client client : result) {
                                        defaultTableModel.addRow(new Object[]{client.getPricePaid(),
                                                  client.isFirstTimeCustomer(),
                                                  client.getEmailListSubscription() });
                                    }

                                    userTable.setModel(defaultTableModel);
                                }
                            });
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }
                    }
                };
                stringSwingWorker.execute();
            }
        });

        locationsWhichAreFull.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<List<Location>, String> stringSwingWorker = new SwingWorker<List<Location>, String>() {
                    @Override
                    protected List<Location> doInBackground() throws Exception {

                        return Service.getInstance().locationsWhichAreFull();
                    }

                    @Override
                    protected void done() {

                        try {
                            List<Location> result = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };

                                    defaultTableModel.addColumn("Place");
                                    defaultTableModel.addColumn("Is full");
                                    defaultTableModel.addColumn("Means of booking");
                                    defaultTableModel.addColumn("Accepts booking");
                                    defaultTableModel.addColumn("City");

                                    for (Location location : result) {
                                        defaultTableModel.addRow(new Object[]{location.getPlaceName(),
                                                  location.isFull(), location.getMeansOfBooking(),
                                                  location.isAcceptsBooking(), location.getCity()});
                                    }
                                    userTable.setModel(defaultTableModel);
                                }
                            });

                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }
                    }
                };
                stringSwingWorker.execute();
            }
        });

//        DB Storage
        INSERTAgencyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ServiceAgencyDB.getInstance().insertAgencyDB(Integer
                                    .parseInt(textFieldPricePaid.getText())
                            ,Boolean.parseBoolean(textFieldFirstTimeCustomer.getText()),
                            textFieldEmailList.getText(),
                            Integer.parseInt(textFieldNoOfBookings.getText()),
                            textFieldCompanyName.getText());
                    JOptionPane.showMessageDialog(null,
                            "Agency successfully inserted !",
                            "Atenție", JOptionPane.INFORMATION_MESSAGE);

                    textFieldPricePaid.setText("");
                    textFieldFirstTimeCustomer.setText("");
                    textFieldEmailList.setText("");
                    textFieldNoOfBookings.setText("");
                    textFieldCompanyName.setText("");

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        DELETEAgencyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(textFieldId.getText());
                if (id >= 0) {
                    try {
                        ServiceAgencyDB.getInstance().deleteAgencyBDByid(id);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null,
                            "Agency was successfully deleted !",
                            "Atenție", JOptionPane.INFORMATION_MESSAGE);

                    textFieldPricePaid.setText("");
                    textFieldFirstTimeCustomer.setText("");
                    textFieldEmailList.setText("");
                    textFieldNoOfBookings.setText("");
                    textFieldCompanyName.setText("");
                }
            }
        });

        UPDATEAgencyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(textFieldId.getText());

               if (id >= 0) {
                    try {
                        ServiceAgencyDB.getInstance().updateAgencyBDById(id);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null,
                            "Agency successfully updated !",
                            "Atenție", JOptionPane.INFORMATION_MESSAGE);

                    textFieldPricePaid.setText("");
                    textFieldFirstTimeCustomer.setText("");
                    textFieldEmailList.setText("");
                    textFieldNoOfBookings.setText("");
                    textFieldCompanyName.setText("");
                }
            }
        });

    }

    public static void main (String args[]){
        UIService mainFrame = new UIService();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainFrame.initGUI();
            }
        });
    }

    public void initGUI () {
        JFrame jFrame = new JFrame("Service clients");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setPreferredSize(new Dimension(800, 600));
        jFrame.setContentPane(this.mainPanel);
        // set prefered size, otherwise your jFrame is going to be something small in a corner
        jFrame.setPreferredSize(new Dimension(800, 600));

        // make the jFrame visible
        jFrame.pack();
        jFrame.setVisible(true);
    }

    private void createUIComponents () {
        JButton oneButton = new JButton("do something!!!!");
        oneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button 'do something!!!!' was pressed!");
            }
        });
        // create manually a new panel, like we already said, this is custom
        Find = new JPanel();
        Find.add(oneButton);
    }
}