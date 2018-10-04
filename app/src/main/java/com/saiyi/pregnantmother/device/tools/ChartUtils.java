package com.saiyi.pregnantmother.device.tools;

import android.graphics.Color;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.saiyi.pregnantmother.R;

import java.util.List;

public class ChartUtils {

    /**
     * 初始化图表
     *
     * @param chart 原始图表
     * @return 初始化后的图表
     */
    public static LineChart initChart(LineChart chart) {
        // 不显示数据描述
        chart.getDescription().setEnabled(false);
        // 没有数据的时候，显示“暂无数据”
        chart.setNoDataText("暂无数据");
        // 不显示表格颜色
        chart.setDrawGridBackground(false);
        // 不可以缩放
        chart.setScaleEnabled(false);
        // 不显示y轴右边的值
        chart.getAxisRight().setEnabled(false);
        // 显示图例
        Legend legend = chart.getLegend();
        legend.setPosition(Legend.LegendPosition.ABOVE_CHART_LEFT);
        legend.setTextColor(Color.parseColor("#555555"));
        legend.setTextSize(10);

        XAxis xAxis = chart.getXAxis();
        // 不显示x轴
        xAxis.setDrawAxisLine(true);
        // 设置x轴数据的位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.parseColor("#555555"));
        xAxis.setTextSize(10);
        xAxis.setGridColor(Color.parseColor("#DCDDDD"));
        // 设置x轴数据偏移量
//        xAxis.setYOffset(-12);

        YAxis yAxis = chart.getAxisLeft();
        // 不显示y轴
        yAxis.setDrawAxisLine(false);
        // 设置y轴数据的位置
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        // 不从y轴发出横向直线
        yAxis.setDrawGridLines(false);
        yAxis.setTextColor(Color.parseColor("#555555"));
        yAxis.setTextSize(10);
        // 设置y轴数据偏移量
//        yAxis.setXOffset(30);
//        yAxis.setYOffset(-3);
//        yAxis.setAxisMinimum(0);

        chart.invalidate();
        return chart;
    }

    /**
     * 设置图表数据
     *
     * @param chart  图表
     * @param values 数据
     */
    public static void setChartData(LineChart chart, List<Entry> values) {
        LineDataSet lineDataSet;

        if (chart.getData() != null && chart.getData().getDataSetCount() > 0) {
            lineDataSet = (LineDataSet) chart.getData().getDataSetByIndex(0);
            lineDataSet.setValues(values);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();
        } else {
            lineDataSet = new LineDataSet(values, "bpm");
            lineDataSet.setLineWidth(2);
            // 设置曲线颜色
            lineDataSet.setColor(Color.parseColor("#69C16C"));
            // 设置平滑曲线
            lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            // 不显示坐标点的小圆点
            lineDataSet.setDrawCircles(false);
            // 不显示坐标点的数据
            lineDataSet.setDrawValues(false);
            // 不显示定位线
            lineDataSet.setHighlightEnabled(false);

            LineData data = new LineData(lineDataSet);

            chart.setData(data);
            chart.invalidate();
        }
    }

    /**
     * 更新图表
     *
     * @param chart  图表
     * @param values 数据
     */
    public static void notifyDataSetChanged(LineChart chart, List<Entry> values) {
        chart.getXAxis().setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xValuesProcess()[(int) value];
            }
        });
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setAxisMaximum(200);
        leftAxis.setAxisMinimum(60);
        leftAxis.setLabelCount(8, false);

        chart.invalidate();
        setChartData(chart, values);
    }

    /**
     * x轴数据处理
     *
     * @return x轴数据
     */
    private static String[] xValuesProcess() {
        return new String[]{
                "00.10",
                "00.20",
                "00.30",
                "00.40",
                "00.50",
                "01.00",
                "01.10",
                "01.20",
                "01.30",
                "01.40",
                "01.50"
        };
    }
}
