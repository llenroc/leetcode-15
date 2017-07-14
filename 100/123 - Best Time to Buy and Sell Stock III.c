#include <limits.h>

#define max(a, b) (a > b ? a : b)
#define min(a, b) (a < b ? a : b)

int maxProfit(int* prices, int pricesSize) {
    int *left_profits, max_profit = 0, max_right_profit = 0, i, prev_price;
    
    if (! pricesSize)
        return 0;
    left_profits = (int *)malloc(pricesSize * sizeof(int));
    
    prev_price = prices[0];
    left_profits[0] = 0;
    for (i = 1; i < pricesSize; ++i) {
        left_profits[i] = max(left_profits[i - 1], prices[i] - prev_price);
        prev_price = min(prev_price, prices[i]);
    }
    
    prev_price = prices[pricesSize - 1];
    max_profit = left_profits[pricesSize - 1];
    for (i = pricesSize - 2; i >= 1; --i) {
        max_right_profit = max(max_right_profit, prev_price - prices[i]);
        prev_price = max(prev_price, prices[i]);
        max_profit = max(max_profit, max_right_profit + left_profits[i - 1]);
    }
    
    free(left_profits);
    
    return max_profit;
}
