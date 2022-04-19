package LeetCode;


class ContainerWithMostWater {

  public int maxArea(int[] height) {
    int max = Integer.MIN_VALUE;
    int i = 0;
    int j = height.length - 1;

    while (i < j) {
      max = Math.max(max, Math.min(height[i], height[j]) * Math.abs(i - j));
      if (height[i] <= height[j]) {
        i++;
      } else {
        j--;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

    System.out.println(new ContainerWithMostWater().maxArea(arr));
  }
}
