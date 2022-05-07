https://leetcode.com/problems/find-in-mountain-array/

    package LeetCode;

    public class FindInMountainArray {
        public static int peak(MountainArray mountainArr) {
            int start = 0;
            int end = mountainArr.length() - 1;

            while (start < end) {
                int mid = start + (end - start) / 2;

                if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                    end = mid;
                } else if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                    start = mid + 1;
                }
            }
            return start;
        }

        public static int search(int target, MountainArray mountainArr, int start, int end) {
            boolean isAsc = mountainArr.get(start) < mountainArr.get(end);

            while (start <= end) {
                int mid = start + (end - start) / 2;
                int midVal = mountainArr.get(mid);

                if (target == midVal) {
                    return mid;
                }

                if (isAsc) {
                    if (target > midVal) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (target > midVal) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
            return -1;
        }

        public int findInMountainArray(int target, MountainArray mountainArr) {
            int peakV = peak(mountainArr);

            int firstTry = search(target, mountainArr, 0, peakV);

            if (firstTry != -1) {
                return firstTry;
            }
            
            // peak+1 to end
            return search(target, mountainArr, peakV + 1, mountainArr.length() - 1);

            // if(target > mountainArr.get(peakV)){
            // return search(target, mountainArr,peakV + 1, mountainArr.length() - 1);
            // }else{
            // return search(target, mountainArr,0,peakV );
            // }
        }
    }
