/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import logica.fperfilusuario;
import logica.ftrabajador;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.MinMaxCategoryRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author crist
 */
public class frmperfil extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmperfil
     */
    public frmperfil() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        proyeccion();
        evolutivodinero();
        frecuenciacumpl();
        mixmaxavg();               
        
    }

    DecimalFormat numberFormat = new DecimalFormat("#,##0.0;(#,##0.0)");

    void lblactivar() {

        lblnombre.setText(INICIO.lblinicionombre.getText() + " " + INICIO.lblinicio1erapellido.getText()
                + " " + INICIO.lblinicio2doapellido.getText());
        lblcargo.setText( ftrabajador.logincargo);
        lblarea.setText(INICIO.lblinicioarea.getText());
        lblsubarea.setText( INICIO.lbliniciosubarea.getText());

        if (fperfilusuario.ganadomespasado == 0.0) {
            lblhasganado.setText("");
          
            lblvalorganado.setForeground(Color.WHITE);
        } else {

            lblvalorganado.setText("$ " + numberFormat.format(fperfilusuario.ganadomespasado));
            lblvalorganado.setIcon(new ImageIcon(frmperfil.class.getResource("/img/trofeo.png")));
            lblvalorganado.setHorizontalTextPosition(SwingConstants.LEFT);

        }
        
        
        

    }

    void proyeccion() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String year = timeStamp.substring(0, 4);
        String mes = Integer.toString(Integer.parseInt(timeStamp.substring(4, 6)) - 1);

        try {
            DefaultPieDataset dataset = new DefaultPieDataset();
            fperfilusuario func = new fperfilusuario();
            dataset = func.proyeccion();

            if (dataset == null) {
                dataset.setValue("no Hay valores", 0);
            }

            JFreeChart chart = ChartFactory.createPieChart(
                    "Mi Proyección " + year + " /" + mes, // chart title 
                    dataset, // data    
                    true, // include legend   
                    true,
                    false);
            chart.getTitle().setPaint(new Color(75,16,160));
            PiePlot plot = (PiePlot) chart.getPlot();
            PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                    "{0}: {1} ({2})", new DecimalFormat("$" + "#,##0.0;(#,##0.0)"), new DecimalFormat("0%"));
            plot.setLabelGenerator(gen);
            plot.setLabelOutlinePaint(null);
            plot.setLabelShadowPaint(null);
            plot.setLabelBackgroundPaint(null);
            plot.setLabelPaint(new Color(75,16,160));
            plot.setBackgroundPaint(Color.WHITE);
            // plot.setSimpleLabels(true);
            plot.setOutlineVisible(false);
            chart.setBackgroundPaint(Color.WHITE);
            plot.setSectionPaint(0, new Color(20, 173, 23));
            plot.setSectionPaint(1, new Color(101, 54, 193));
            final ChartPanel chartPanel = new ChartPanel(chart);
            chart.getLegend().setFrame(BlockBorder.NONE);
            pnlproyeccion.setLayout(new java.awt.BorderLayout());
            pnlproyeccion.add(chartPanel, BorderLayout.CENTER);
            pnlproyeccion.validate();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }

    }

    void evolutivodinero() {

        ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());

        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            fperfilusuario func = new fperfilusuario();
            dataset = func.evolutivodinero();

            final CategoryItemRenderer renderer = new StackedBarRenderer();
            renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("$" + "#,##0.0;(#,##0.0)"), new DecimalFormat("0%")));
            renderer.setItemLabelPaint(new Color(75,16,160));
            renderer.setItemLabelsVisible(true);
            renderer.setSeriesPaint(0, new Color(20, 173, 23));
            renderer.setSeriesPaint(1, new Color(238, 238, 221));
            renderer.setBaseItemLabelsVisible(true);
            final CategoryPlot plot = new CategoryPlot();
            plot.setBackgroundPaint(Color.WHITE);
            plot.setForegroundAlpha(0.8f);
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.WHITE);
            plot.setDataset(dataset);
            plot.setRenderer(renderer);
            plot.setDomainAxis(new CategoryAxis(""));
            plot.setRangeAxis(new NumberAxis("$"));
            plot.setOrientation(PlotOrientation.VERTICAL);
            plot.setRangeGridlinesVisible(true);
            plot.setDomainGridlinesVisible(true);
            plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
            plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
            final JFreeChart chart = new JFreeChart(plot);
            chart.setBackgroundPaint(Color.WHITE);
            chart.setTitle("Mi Evolutivo");
            chart.getTitle().setPaint(new Color(75,16,160));
            chart.getLegend().setFrame(BlockBorder.NONE);
            plot.getDomainAxis().setTickLabelPaint(new Color(75,16,160));
            plot.getRangeAxis().setTickLabelPaint(new Color(75,16,160));
            plot.getRangeAxis().setLabelPaint(new Color(75,16,160));
            plot.getDomainAxis().setLabelPaint(new Color(75,16,160));
            plot.setOutlineVisible(false);
            final ChartPanel chartPanel = new ChartPanel(chart);
            pnlevoluciondinero.setLayout(new java.awt.BorderLayout());
            pnlevoluciondinero.add(chartPanel, BorderLayout.CENTER);
            pnlevoluciondinero.validate();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }

    }

    void frecuenciacumpl() {

        ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());

        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            fperfilusuario func = new fperfilusuario();
            dataset = func.frecuenciacumpli();

            final CategoryItemRenderer renderer = new BarRenderer();
            renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("#,##0%;(#,##0)"), new DecimalFormat("0%")));
            renderer.setItemLabelPaint(new Color(75,16,160));
            renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.HALF_ASCENT_CENTER));
            renderer.setItemLabelsVisible(true);
            renderer.setSeriesPaint(0, new Color(20, 173, 23));
            renderer.setSeriesPaint(1, new Color(238, 238, 221));
           
            final CategoryPlot plot = new CategoryPlot();
            plot.setBackgroundPaint(Color.WHITE);
            plot.setForegroundAlpha(0.8f);
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.WHITE);
            plot.setDataset(dataset);
            plot.setRenderer(renderer);
            plot.setDomainAxis(new CategoryAxis(""));
            plot.setRangeAxis(new NumberAxis("% Cumplimiento Acumulado"));
            plot.setOrientation(PlotOrientation.VERTICAL);
            plot.setRangeGridlinesVisible(true);
            plot.setDomainGridlinesVisible(true);
            plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
            plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
            final JFreeChart chart = new JFreeChart(plot);
            chart.setBackgroundPaint(Color.WHITE);
            chart.setTitle("Mi Cumplimiento");
            chart.getTitle().setPaint(new Color(75,16,160));
            chart.getLegend().setFrame(BlockBorder.NONE);
            plot.getDomainAxis().setTickLabelPaint(new Color(75,16,160));
            plot.getRangeAxis().setTickLabelPaint(new Color(75,16,160));
            plot.getRangeAxis().setLabelPaint(new Color(75,16,160));
            plot.getDomainAxis().setLabelPaint(new Color(75,16,160));
            plot.setOutlineVisible(false);
            final ChartPanel chartPanel = new ChartPanel(chart);
            pnlcumplimiento.setLayout(new java.awt.BorderLayout());
            pnlcumplimiento.add(chartPanel, BorderLayout.CENTER);
            pnlcumplimiento.validate();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }

    }

    void mixmaxavg() {

        ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());

        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            fperfilusuario func = new fperfilusuario();
            dataset = func.mixmaxavg();

            JFreeChart chart = ChartFactory.createBarChart(
                    "Min/Max Category Plot", // chart title
                    "", // domain axis label
                    "Obtenido", // range axis label
                    dataset, // data
                    PlotOrientation.VERTICAL,
                    true, // include legend
                    true, // tooltips
                    false // urls
            );

            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            plot.setRangePannable(true);
            MinMaxCategoryRenderer renderer = new MinMaxCategoryRenderer();
            renderer.setDrawLines(false);
            plot.setRenderer(renderer);
            ChartUtilities.applyCurrentTheme(chart);

            renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            renderer.setItemLabelPaint(new Color(75,16,160));
            renderer.setItemLabelsVisible(true);
            renderer.setSeriesPaint(1, new Color(255, 5, 5));
            renderer.setSeriesStroke(1, new BasicStroke(4));
            renderer.setSeriesPaint(0, new Color(255, 151, 5));
            renderer.setSeriesStroke(0, new BasicStroke(4));
             renderer.setSeriesPaint(2, new Color(5, 255, 22));
             renderer.setSeriesStroke(2, new BasicStroke(4));
             renderer.setSeriesPaint(3, new Color(75,16,160));
             renderer.setSeriesStroke(3, new BasicStroke(6));
            renderer.setBaseItemLabelsVisible(true);
            plot.setBackgroundPaint(Color.WHITE);
            plot.setForegroundAlpha(0.8f);
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.WHITE);
            plot.setDataset(dataset);
            plot.setRenderer(renderer);
            plot.setDomainAxis(new CategoryAxis(""));
            plot.setRangeAxis(new NumberAxis("$"));
            plot.setOrientation(PlotOrientation.VERTICAL);
            plot.setRangeGridlinesVisible(true);
            plot.setDomainGridlinesVisible(true);
            plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
            plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
            chart.setBackgroundPaint(Color.WHITE);
            chart.setTitle("Mi Promedio");
            chart.getTitle().setPaint(new Color(75,16,160));
            chart.getLegend().setFrame(BlockBorder.NONE);
            plot.getDomainAxis().setTickLabelPaint(new Color(75,16,160));
            plot.getRangeAxis().setTickLabelPaint(new Color(75,16,160));
            plot.getRangeAxis().setLabelPaint(new Color(75,16,160));
            plot.getDomainAxis().setLabelPaint(new Color(75,16,160));
            plot.setOutlineVisible(false);

            final ChartPanel chartPanel = new ChartPanel(chart);
            pnlmiarea2.setLayout(new java.awt.BorderLayout());
            pnlmiarea2.add(chartPanel, BorderLayout.CENTER);
            pnlmiarea2.validate();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnldatos = new javax.swing.JPanel();
        lblnombre = new javax.swing.JLabel();
        lblcargo = new javax.swing.JLabel();
        lblarea = new javax.swing.JLabel();
        lblsubarea = new javax.swing.JLabel();
        lblhasganado = new javax.swing.JLabel();
        lblvalorganado = new javax.swing.JLabel();
        pnlproyeccion = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        pnlmiarea = new javax.swing.JPanel();
        pnlevoluciondinero = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        pnlmiarea2 = new javax.swing.JPanel();
        pnlcumplimiento = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 1000));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(200, 400));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 400));
        jPanel2.setLayout(new java.awt.GridLayout(2, 1, 0, 10));

        pnldatos.setBackground(new java.awt.Color(255, 255, 255));
        pnldatos.setPreferredSize(new java.awt.Dimension(0, 0));

        lblnombre.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(75, 16, 160));
        lblnombre.setText("nombre");

        lblcargo.setFont(new java.awt.Font("Arial", 2, 15)); // NOI18N
        lblcargo.setForeground(new java.awt.Color(75, 16, 160));
        lblcargo.setText("cargo");

        lblarea.setFont(new java.awt.Font("Arial", 2, 15)); // NOI18N
        lblarea.setForeground(new java.awt.Color(75, 16, 160));
        lblarea.setText("area");

        lblsubarea.setFont(new java.awt.Font("Arial", 2, 15)); // NOI18N
        lblsubarea.setForeground(new java.awt.Color(75, 16, 160));
        lblsubarea.setText("subarea");

        lblhasganado.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lblhasganado.setForeground(new java.awt.Color(0, 0, 0));
        lblhasganado.setText("Ganado mes anterior:");

        lblvalorganado.setFont(new java.awt.Font("abeatbyKai", 1, 36)); // NOI18N
        lblvalorganado.setForeground(new java.awt.Color(20, 201, 29));
        lblvalorganado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblvalorganado.setText("Valor obtenido");
        lblvalorganado.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout pnldatosLayout = new javax.swing.GroupLayout(pnldatos);
        pnldatos.setLayout(pnldatosLayout);
        pnldatosLayout.setHorizontalGroup(
            pnldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblvalorganado, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addGroup(pnldatosLayout.createSequentialGroup()
                        .addGroup(pnldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnombre)
                            .addComponent(lblhasganado)
                            .addGroup(pnldatosLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(pnldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblarea)
                                    .addComponent(lblcargo)
                                    .addComponent(lblsubarea))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnldatosLayout.setVerticalGroup(
            pnldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldatosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblnombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblcargo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblarea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblsubarea)
                .addGap(32, 32, 32)
                .addComponent(lblhasganado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblvalorganado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(pnldatos);

        pnlproyeccion.setBackground(new java.awt.Color(255, 255, 255));
        pnlproyeccion.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout pnlproyeccionLayout = new javax.swing.GroupLayout(pnlproyeccion);
        pnlproyeccion.setLayout(pnlproyeccionLayout);
        pnlproyeccionLayout.setHorizontalGroup(
            pnlproyeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlproyeccionLayout.setVerticalGroup(
            pnlproyeccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(pnlproyeccion);

        jPanel1.add(jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMinimumSize(new java.awt.Dimension(200, 400));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 400));
        jPanel5.setLayout(new java.awt.GridLayout(2, 0, 0, 10));

        pnlmiarea.setBackground(new java.awt.Color(255, 255, 255));
        pnlmiarea.setForeground(new java.awt.Color(204, 204, 255));
        pnlmiarea.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout pnlmiareaLayout = new javax.swing.GroupLayout(pnlmiarea);
        pnlmiarea.setLayout(pnlmiareaLayout);
        pnlmiareaLayout.setHorizontalGroup(
            pnlmiareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        pnlmiareaLayout.setVerticalGroup(
            pnlmiareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        jPanel5.add(pnlmiarea);

        pnlevoluciondinero.setBackground(new java.awt.Color(255, 255, 255));
        pnlevoluciondinero.setForeground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout pnlevoluciondineroLayout = new javax.swing.GroupLayout(pnlevoluciondinero);
        pnlevoluciondinero.setLayout(pnlevoluciondineroLayout);
        pnlevoluciondineroLayout.setHorizontalGroup(
            pnlevoluciondineroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlevoluciondineroLayout.setVerticalGroup(
            pnlevoluciondineroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(pnlevoluciondinero);

        jPanel1.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMinimumSize(new java.awt.Dimension(200, 400));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 400));
        jPanel6.setLayout(new java.awt.GridLayout(2, 0, 0, 10));

        pnlmiarea2.setBackground(new java.awt.Color(255, 255, 255));
        pnlmiarea2.setForeground(new java.awt.Color(204, 204, 255));
        jPanel6.add(pnlmiarea2);

        pnlcumplimiento.setBackground(new java.awt.Color(255, 255, 255));
        pnlcumplimiento.setForeground(new java.awt.Color(255, 204, 51));

        javax.swing.GroupLayout pnlcumplimientoLayout = new javax.swing.GroupLayout(pnlcumplimiento);
        pnlcumplimiento.setLayout(pnlcumplimientoLayout);
        pnlcumplimientoLayout.setHorizontalGroup(
            pnlcumplimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlcumplimientoLayout.setVerticalGroup(
            pnlcumplimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.add(pnlcumplimiento);

        jPanel1.add(jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        lblactivar();        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmperfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmperfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmperfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmperfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmperfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblarea;
    private javax.swing.JLabel lblcargo;
    private javax.swing.JLabel lblhasganado;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblsubarea;
    private javax.swing.JLabel lblvalorganado;
    private javax.swing.JPanel pnlcumplimiento;
    private javax.swing.JPanel pnldatos;
    private javax.swing.JPanel pnlevoluciondinero;
    private javax.swing.JPanel pnlmiarea;
    private javax.swing.JPanel pnlmiarea2;
    private javax.swing.JPanel pnlproyeccion;
    // End of variables declaration//GEN-END:variables
}
