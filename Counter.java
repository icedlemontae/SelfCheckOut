package HYPERMARKET;

import java.awt.event.*;
import java.util.*;
import java.util.stream.*;
import javax.swing.*;
import javax.swing.table.*;

public class Counter extends javax.swing.JFrame {
    private int counterNum = 0;
    
 // declare all variables
    private javax.swing.JLabel counterlabel;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    

    /**
     * Creates new form CounterUI
     */
    public Counter(int counterNumber) {
        this.counterNum = counterNumber;
        initComponents();
        pack();
        setLocationRelativeTo(null);
        counterlabel.setText("Counter " + counterNumber);
        if (counterNumber == 1) {
            displayCustomer(main.Main.getCounter1());
        } else if (counterNumber == 2) {
            displayCustomer(main.Main.getCounter2());
        } else if (counterNumber == 3) {
            displayCustomer(main.Main.getCounter3());
        }
    }

    private void displayCustomer(Queue counter) {
        String currentCustID = "";
        DefaultTableModel customerTableModel = (DefaultTableModel) customerTable.getModel();
        customerTableModel.setRowCount(0);
        //TO CONVERT, NEED TO FILTER CUSTOMER ONLY AND ADD TO NEW LIST
        List<CustomerInformation> convertedCustList = (List<CustomerInformation>) counter.stream().collect(Collectors.toList());

        int custCount = 0;
        for (Iterator itr = convertedCustList.iterator(); itr.hasNext();) {
            CustomerInformation nextCustomerData = (CustomerInformation) itr.next();
            if (!nextCustomerData.getCustID().equalsIgnoreCase(currentCustID)) {
                currentCustID = nextCustomerData.getCustID();
                custCount++;
                customerTableModel.addRow(new Object[]{nextCustomerData.getCustID(), nextCustomerData.getCustIC(), nextCustomerData.getCustName()});
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        counterlabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Counter");

        jPanel2.setBackground(java.awt.Color.BLACK);

        counterlabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        counterlabel.setForeground(new java.awt.Color(144,238,144));  //light green
        counterlabel.setText("Counter 0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(counterlabel)
                .addContainerGap(713, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(counterlabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CUSTOMER ID", "CUSTOMER IC", "NAME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(customerTable);

        jButton1.setText("Pay by queue");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Open customer item");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Payment payment;
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //PAY PROCESS HERE
        if (payment == null) {
            //GET WHO FIRST QUEUE OF CUSTOMER
            CustomerInformation datacust = null;
            if (counterNum == 1) {
                datacust = (CustomerInformation) main.Main.getCounter1().peek();
            } else if (counterNum == 2) {
                datacust = (CustomerInformation) main.Main.getCounter2().peek();
            } else if (counterNum == 3) {
                datacust = (CustomerInformation) main.Main.getCounter3().peek();
            }
            if (datacust == null) {
                JOptionPane.showMessageDialog(null, "No Customer Queue to Pay", "No Customer", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String custIDPay = datacust.getCustID();
            double totalPayment = 0;

            List<CustomerInformation> convertedItemList = null;
            List<CustomerInformation> filteredItemListCust = null;
            if (counterNum == 1) {
                convertedItemList = (List<CustomerInformation>) main.Main.getCounter1().stream().collect(Collectors.toList());
                filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custIDPay)).collect(Collectors.toList());
            } else if (counterNum == 2) {
                convertedItemList = (List<CustomerInformation>) main.Main.getCounter2().stream().collect(Collectors.toList());
                filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custIDPay)).collect(Collectors.toList());
            } else if (counterNum == 3) {
                convertedItemList = (List<CustomerInformation>) main.Main.getCounter3().stream().collect(Collectors.toList());
                filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custIDPay)).collect(Collectors.toList());
            }

            int countitem = 0;
            for (Iterator iterator = filteredItemListCust.iterator(); iterator.hasNext();) {
                CustomerInformation nextItemData = (CustomerInformation) iterator.next();
                countitem++;
                //CALCULATE TOTAL PAYMENT HERE
                totalPayment = totalPayment + nextItemData.getitemPrice();
            }

            payment = new Payment(custIDPay, totalPayment, counterNum, countitem);
            payment.setVisible(true);
            payment.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    if (counterNum == 1) {
                        displayCustomer(main.Main.getCounter1());
                    } else if (counterNum == 2) {
                        displayCustomer(main.Main.getCounter2());
                    } else if (counterNum == 3) {
                        displayCustomer(main.Main.getCounter3());
                    }
                    payment = null;
                }

            });
        } else {
            payment.setVisible(true);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    Map<String, ItemList> itemInstance = new TreeMap<String, ItemList>();
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        String custID = JOptionPane.showInputDialog("ENTER CUSTOMER ID: ");
        ItemList getItemUI = itemInstance.get("items" + custID);
        if (getItemUI == null) {
            ItemList newItemUI = new ItemList(custID, counterNum);
            itemInstance.put("items" + custID, newItemUI);
            newItemUI.setVisible(true);
        } else {
            getItemUI.setVisible(true);
        }
    }//GEN-LAST:event_jButton2MouseClicked

}
