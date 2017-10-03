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
        lblcargo.setText("Cargo: " + ftrabajador.logincargo);
        lblarea.setText("Área: " + INICIO.lblinicioarea.getText());
        lblsubarea.setText("SubÁrea: " + INICIO.lbliniciosubarea.getText());

        if (fperfilusuario.ganadomespasado == 0.0) {
            lblhasganado.setText("No ganaste aun");
            lblhasganado.setForeground(Color.RED);
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
            chart.getTitle().setPaint(new Color(53, 29, 113));
            PiePlot plot = (PiePlot) chart.getPlot();
            PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                    "{0}: {1} ({2})", new DecimalFormat("$" + "#,##0.0;(#,##0.0)"), new DecimalFormat("0%"));
            plot.setLabelGenerator(gen);
            plot.setLabelOutlinePaint(null);
            plot.setLabelShadowPaint(null);
            plot.setLabelBackgroundPaint(null);
            plot.setLabelPaint(new Color(53, 29, 113));
            plot.setBackgroundPaint(Color.WHITE);
            // plot.setSimpleLabels(true);
            plot.setOutlineVisible(false);
            chart.setBackgroundPaint(Color.WHITE);
            plot.setSectionPaint(0, new Color(121, 152, 40));
            plot.setSectionPaint(1, new Color(49, 95, 118));
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
            renderer.setItemLabelPaint(new Color(53, 29, 113));
            renderer.setItemLabelsVisible(true);
            renderer.setSeriesPaint(0, new Color(121, 152, 40));
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
            chart.getTitle().setPaint(new Color(53, 29, 113));
            chart.getLegend().setFrame(BlockBorder.NONE);
            plot.getDomainAxis().setTickLabelPaint(new Color(53, 29, 113));
            plot.getRangeAxis().setTickLabelPaint(new Color(53, 29, 113));
            plot.getRangeAxis().setLabelPaint(new Color(53, 29, 113));
            plot.getDomainAxis().setLabelPaint(new Color(53, 29, 113));
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
            renderer.setItemLabelPaint(new Color(53, 29, 113));
            renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.HALF_ASCENT_CENTER));
            renderer.setItemLabelsVisible(true);
            renderer.setSeriesPaint(0, new Color(121, 152, 40));
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
            plot.setRangeAxis(new NumberAxis("% Cumplimiento Acumulado"));
            plot.setOrientation(PlotOrientation.VERTICAL);
            plot.setRangeGridlinesVisible(true);
            plot.setDomainGridlinesVisible(true);
            plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
            plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
            final JFreeChart chart = new JFreeChart(plot);
            chart.setBackgroundPaint(Color.WHITE);
            chart.setTitle("Mi Cumplimiento");
            chart.getTitle().setPaint(new Color(53, 29, 113));
            chart.getLegend().setFrame(BlockBorder.NONE);
            plot.getDomainAxis().setTickLabelPaint(new Color(53, 29, 113));
            plot.getRangeAxis().setTickLabelPaint(new Color(53, 29, 113));
            plot.getRangeAxis().setLabelPaint(new Color(53, 29, 113));
            plot.getDomainAxis().setLabelPaint(new Color(53, 29, 113));
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
            renderer.setItemLabelPaint(new Color(53, 29, 113));
            renderer.setItemLabelsVisible(true);
            renderer.setSeriesPaint(1, new Color(255, 5, 5));
            renderer.setSeriesStroke(1, new BasicStroke(4));
            renderer.setSeriesPaint(0, new Color(255, 151, 5));
            renderer.setSeriesStroke(0, new BasicStroke(4));
             renderer.setSeriesPaint(2, new Color(5, 255, 22));
             renderer.setSeriesStroke(2, new BasicStroke(4));
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
            chart.setTitle("Mi Evolutivo");
            chart.getTitle().setPaint(new Color(53, 29, 113));
            chart.getLegend().setFrame(BlockBorder.NONE);
            plot.getDomainAxis().setTickLabelPaint(new Color(53, 29, 113));
            plot.getRangeAxis().setTickLabelPaint(new Color(53, 29, 113));
            plot.getRangeAxis().setLabelPaint(new Color(53, 29, 113));
            plot.getDomainAxis().setLabelPaint(new Color(53, 29, 113));
            plot.setOutlineVisible(false);

            final ChartPanel chartPanel = new ChartPanel(chart);
            pnlmiarea.setLayout(new java.awt.BorderLayout());
            pnlmiarea.add(chartPanel, BorderLayout.CENTER);
            pnlmiarea.validate();

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
        pnlotros = new javax.swing.JPanel();
        btnproyeccion = new javax.swing.JButton();
        btnevolutivo = new javax.swing.JButton();
        btncomparacion = new javax.swing.JButton();
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
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setMinimumSize(new java.awt.Dimension(200, 400));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 400));
        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        pnldatos.setBackground(new java.awt.Color(255, 255, 255));
        pnldatos.setPreferredSize(new java.awt.Dimension(0, 0));

        lblnombre.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(53, 29, 113));
        lblnombre.setText("nombre");

        lblcargo.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lblcargo.setForeground(new java.awt.Color(53, 29, 113));
        lblcargo.setText("cargo");

        lblarea.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lblarea.setForeground(new java.awt.Color(53, 29, 113));
        lblarea.setText("area");

        lblsubarea.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lblsubarea.setForeground(new java.awt.Color(53, 29, 113));
        lblsubarea.setText("subarea");

        lblhasganado.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lblhasganado.setForeground(new java.awt.Color(53, 29, 113));
        lblhasganado.setText("Has Ganado:");

        lblvalorganado.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblvalorganado.setForeground(new java.awt.Color(0, 204, 0));
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
                    .addComponent(lblvalorganado, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addGroup(pnldatosLayout.createSequentialGroup()
                        .addGroup(pnldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblarea)
                            .addComponent(lblnombre)
                            .addComponent(lblcargo)
                            .addComponent(lblsubarea)
                            .addComponent(lblhasganado))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnldatosLayout.setVerticalGroup(
            pnldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblnombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblcargo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblarea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblsubarea)
                .addGap(53, 53, 53)
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

        jPanel5.setMinimumSize(new java.awt.Dimension(200, 400));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 400));
        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        pnlmiarea.setBackground(new java.awt.Color(255, 255, 255));
        pnlmiarea.setForeground(new java.awt.Color(204, 204, 255));
        pnlmiarea.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout pnlmiareaLayout = new javax.swing.GroupLayout(pnlmiarea);
        pnlmiarea.setLayout(pnlmiareaLayout);
        pnlmiareaLayout.setHorizontalGroup(
            pnlmiareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        pnlmiareaLayout.setVerticalGroup(
            pnlmiareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
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

        jPanel6.setMinimumSize(new java.awt.Dimension(200, 400));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 400));
        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        pnlotros.setBackground(new java.awt.Color(255, 255, 255));
        pnlotros.setForeground(new java.awt.Color(204, 204, 255));

        btnproyeccion.setBackground(new java.awt.Color(53, 29, 113));
        btnproyeccion.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnproyeccion.setForeground(new java.awt.Color(255, 255, 255));
        btnproyeccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/analisis.png"))); // NOI18N
        btnproyeccion.setText("Stymuli Proyectado");
        btnproyeccion.setToolTipText("Gráfica proyección estímulo obtenido frente a estímulo posible");
        btnproyeccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnproyeccion.setBorderPainted(false);
        btnproyeccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnproyeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproyeccionActionPerformed(evt);
            }
        });

        btnevolutivo.setBackground(new java.awt.Color(53, 29, 113));
        btnevolutivo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnevolutivo.setForeground(new java.awt.Color(255, 255, 255));
        btnevolutivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/analisis.png"))); // NOI18N
        btnevolutivo.setText("Evolutivo Mensual");
        btnevolutivo.setToolTipText("Gráfica evolutivo mensual");
        btnevolutivo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnevolutivo.setBorderPainted(false);
        btnevolutivo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnevolutivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnevolutivoActionPerformed(evt);
            }
        });

        btncomparacion.setBackground(new java.awt.Color(53, 29, 113));
        btncomparacion.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btncomparacion.setForeground(new java.awt.Color(255, 255, 255));
        btncomparacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/analisis.png"))); // NOI18N
        btncomparacion.setText("Distribucion KPI");
        btncomparacion.setToolTipText("Gráfica comparación KPI, valor objetivo frente a valor obtenido");
        btncomparacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btncomparacion.setBorderPainted(false);
        btncomparacion.setFocusPainted(false);
        btncomparacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btncomparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncomparacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlotrosLayout = new javax.swing.GroupLayout(pnlotros);
        pnlotros.setLayout(pnlotrosLayout);
        pnlotrosLayout.setHorizontalGroup(
            pnlotrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlotrosLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(pnlotrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btncomparacion, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnevolutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnproyeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        pnlotrosLayout.setVerticalGroup(
            pnlotrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlotrosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncomparacion, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnevolutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnproyeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jPanel6.add(pnlotros);

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

    private void btnproyeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproyeccionActionPerformed

        INICIO.pnlmain.removeAll();
        INICIO.pnlmain.revalidate();
        INICIO.pnlmain.repaint();

        frmanalisproyeccion form5chart = new frmanalisproyeccion();
        INICIO.pnlmain.add(form5chart);
        form5chart.toFront();
        form5chart.setVisible(true);
        Dimension desktopSize = INICIO.pnlmain.getSize();
        Dimension jInternalFrameSize = form5chart.getSize();
        form5chart.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);

        this.dispose();

        if (INICIO.lblinicioacceso.getText().equals("Trabajador")) {

            frmanalisproyeccion.pnlarea.setVisible(false);
            frmanalisproyeccion.txtnombrearea.setText(INICIO.lblinicioarea.getText());
            frmanalisproyeccion.pnlsubarea.setVisible(false);
            frmanalisproyeccion.txtnombresubarea.setText(INICIO.lbliniciosubarea.getText());
            frmanalisproyeccion.pnltrabajador.setVisible(false);
            frmanalisproyeccion.txtpersonadocumento.setText(INICIO.lbliniciodocumento.getText());
            frmanalisproyeccion.jPanel2.setVisible(false);
            frmanalisproyeccion.jPanel10.setBackground(Color.WHITE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnproyeccionActionPerformed

    private void btnevolutivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnevolutivoActionPerformed

        INICIO.pnlmain.removeAll();
        INICIO.pnlmain.revalidate();
        INICIO.pnlmain.repaint();

        frmanalisevolutivo form3chart = new frmanalisevolutivo();
        INICIO.pnlmain.add(form3chart);
        form3chart.toFront();
        form3chart.setVisible(true);
        Dimension desktopSize = INICIO.pnlmain.getSize();
        Dimension jInternalFrameSize = form3chart.getSize();
        form3chart.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);

        this.dispose();

        if (INICIO.lblinicioacceso.getText().equals("Trabajador")) {

            frmanalisevolutivo.pnlarea.setVisible(false);
            frmanalisevolutivo.txtnombrearea.setText(INICIO.lblinicioarea.getText());
            frmanalisevolutivo.pnlsubarea.setVisible(false);
            frmanalisevolutivo.txtnombresubarea.setText(INICIO.lbliniciosubarea.getText());
            frmanalisevolutivo.jPanel2.setVisible(false);
            frmanalisevolutivo.jPanel7.setBackground(Color.WHITE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnevolutivoActionPerformed

    private void btncomparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncomparacionActionPerformed

        INICIO.pnlmain.removeAll();
        INICIO.pnlmain.revalidate();
        INICIO.pnlmain.repaint();

        frmanalisdistrikpi form1chart = new frmanalisdistrikpi();
        INICIO.pnlmain.add(form1chart);
        form1chart.toFront();
        form1chart.setVisible(true);
        Dimension desktopSize = INICIO.pnlmain.getSize();
        Dimension jInternalFrameSize = form1chart.getSize();
        form1chart.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);

        this.dispose();

        if (INICIO.lblinicioacceso.getText().equals("Trabajador")) {
            frmanalisdistrikpi.pnlarea.setVisible(false);
            frmanalisdistrikpi.txtnombrearea.setText(INICIO.lblinicioarea.getText());
            frmanalisdistrikpi.pnlsubarea.setVisible(false);
            frmanalisdistrikpi.txtnombresubarea.setText(INICIO.lbliniciosubarea.getText());
            frmanalisdistrikpi.jPanel2.setVisible(false);
            frmanalisdistrikpi.jPanel9.setBackground(Color.WHITE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btncomparacionActionPerformed

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
    public static javax.swing.JButton btncomparacion;
    public static javax.swing.JButton btnevolutivo;
    public static javax.swing.JButton btnproyeccion;
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
    private javax.swing.JPanel pnlotros;
    private javax.swing.JPanel pnlproyeccion;
    // End of variables declaration//GEN-END:variables
}
