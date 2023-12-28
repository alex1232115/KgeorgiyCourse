package task;


import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B {
    public static void main(String[] args) {
//        Order(DELIVERY, "EUR", 2000),
//          Order (DELIVERY, "USD", 15),
//          Order (DELIVERY, "RUB", 200),
//          Order (PICKUP, "RUB", 1250),
//          Order (DELIVERY, "USD", 35),
//          Order (PICKUP, "USD", 55),
//          Order (DELIVERY, "RUB", 100)
//          ќжидаемый результат:
//          ["EUR" -> 0.0, "USD" -> 20.0, "RUB" -> 100.0]

    }

    class OrderService {
        enum Type {DELIVERY, PICKUP}

        static class OrderData {
            final Type type;
            final String currency;
            final Long amount;

            OrderData (@NotNull Type type,
                       @NotNull String currency,
                       @NotNull Long amount) {
                this.type = type;
                this.currency = currency;
                this.amount = amount;
            }

            String getCurrency() {
                return currency;
            }

            Long getAmount() {
                return amount;
            }

            Type getType() {
                return type;
            }
        }

        Map<String, Double> getMaxMinusMinDeliveryMapByCurrency(List<OrderData> orderDataList) {
            class MinMax {
                double min;
                double max;

                public MinMax(double min, double max) {
                    this.min = min;
                    this.max = max;
                }
            }


            Map<String, MinMax> orderMap = new HashMap<>();

            for (OrderData order: orderDataList) {
                if (order.getType() == Type.DELIVERY) {
                    if (!orderMap.containsKey(order.currency)) {
                        orderMap.put(order.currency, new MinMax(order.amount, order.amount));
                    } else {
                        MinMax cur = orderMap.get(order.currency);
                        if (order.amount < cur.min) {
                            cur.min = order.amount;
                        } else if (order.amount > cur.max) {
                            cur.max = order.amount;
                        }
                    }
                }
            }

            Map<String, Double> result = new HashMap<>();
            for (Map.Entry<String, MinMax> entry: orderMap.entrySet()) {
                result.put(entry.getKey(), entry.getValue().max - entry.getValue().min);
            }
            return result;
        }
    }

}
