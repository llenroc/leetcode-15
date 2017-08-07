#include <stdlib.h>

typedef struct {
    int *nums;
    int numsSize;
} Solution;

Solution* solutionCreate(int* nums, int numsSize) {
    Solution *sol = (Solution *)malloc(sizeof(Solution));
    sol->nums = nums;
    sol->numsSize = numsSize;
    
    return sol;
}

int solutionPick(Solution* obj, int target) {
    int count = 0, pick = -1, i;
    
    for (i = 0; i < obj->numsSize; ++i) {
        if (obj->nums[i] == target) {
            ++count;
            if (rand() % count == 0)
                pick = i;
        }
    }
    
    return pick;
}

void solutionFree(Solution* obj) {
    free(obj);
}

/**
 * Your Solution struct will be instantiated and called as such:
 * struct Solution* obj = solutionCreate(nums, numsSize);
 * int param_1 = solutionPick(obj, target);
 * solutionFree(obj);
 */
 