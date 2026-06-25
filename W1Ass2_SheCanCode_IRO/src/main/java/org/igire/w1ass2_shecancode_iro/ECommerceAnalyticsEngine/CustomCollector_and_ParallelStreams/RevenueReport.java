package org.igire.w1ass2_shecancode_iro.ECommerceAnalyticsEngine.CustomCollector_and_ParallelStreams;

import org.igire.w1ass2_shecancode_iro.ECommerceAnalyticsEngine.StreamPipelineforProductAnalytics.LineItem;

import java.util.stream.Collector;

public class RevenueReport {
    double totalRevenue = 0;
    long itemCount = 0;
    double maxRevenue = 0;

    public void combine(LineItem item) {
        double itemRevenue = item.getPrice() * item.getQuantity();
        totalRevenue += itemRevenue;
        itemCount++;
        maxRevenue = Math.max(maxRevenue, itemRevenue);
    }

    public static Collector<LineItem, RevenueReport, RevenueReport> collector() {
        return Collector.of(RevenueReport::new, RevenueReport::combine, (r1, r2) -> {
            r1.totalRevenue += r2.totalRevenue;
            r1.itemCount += r2.itemCount;
            r1.maxRevenue = Math.max(r1.maxRevenue, r2.maxRevenue);
            return r1;
        });
    }
}
