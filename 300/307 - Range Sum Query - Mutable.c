typedef struct {
    int *nums;
    int *bits;
    size_t size;
} NumArray;

NumArray* numArrayCreate(int* nums, int numsSize) {
    int i;
    NumArray *array = (NumArray *)malloc(sizeof(NumArray));
    
    array->nums = (int *)calloc(2 * (numsSize + 1), sizeof(int));
    array->bits = array->nums + (numsSize + 1);
    array->size = numsSize;
    
    for (i = 0; i < numsSize; ++i)
        numArrayUpdate(array, i, nums[i]);
    
    return array;
}

void numArrayUpdate(NumArray* obj, int i, int val) {
    int diff = val - obj->nums[i + 1], j;
    
    obj->nums[i + 1] += diff;
    
    for (j = i + 1; j <= obj->size; j += (j & -j))
        obj->bits[j] += diff;
}

int numArraySum(NumArray *obj, int i) {
    int ret = 0;
    
    for (; i > 0; i -= (i & -i))
        ret += obj->bits[i];
    
    return ret;
}

int numArraySumRange(NumArray* obj, int i, int j) {
    return numArraySum(obj, j + 1) - numArraySum(obj, i);
}

void numArrayFree(NumArray* obj) {
    free(obj->nums);
    free(obj);
}

/**
 * Your NumArray struct will be instantiated and called as such:
 * struct NumArray* obj = numArrayCreate(nums, numsSize);
 * numArrayUpdate(obj, i, val);
 * int param_2 = numArraySumRange(obj, i, j);
 * numArrayFree(obj);
 */
 