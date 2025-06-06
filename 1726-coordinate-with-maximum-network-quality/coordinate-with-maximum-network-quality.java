class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] minXY = {51, 51};
        int[] maxXY = {0,0};
        int bestQuality = 0, qualityCandidate = 0;
        int[] bestPoint = {0, 0};
        int squareRadius = radius * radius;
        setMinAndMax(towers, minXY, maxXY);
        for (int x = minXY[0]; x <= maxXY[0]; x++) {
            for (int y = minXY[1]; y <= maxXY[1]; y++) {
                qualityCandidate = calculateNetworkQuality(x, y, towers, squareRadius);
                if (qualityCandidate > bestQuality) {
                    bestQuality = qualityCandidate;
                    bestPoint[0] = x;
                    bestPoint[1] = y;
                }
            }
        }
        return bestPoint;
    }

    private int calculateNetworkQuality(int x, int y, int[][] towers, int squareRadius) {
        int quality = 0;
        double distance;
        for (int[] tower : towers) {
            distance = (x - tower[0]) * (x - tower[0]) + (y - tower[1]) * (y - tower[1]);
            if (distance <= squareRadius) {
                quality += (tower[2] / (1 + Math.sqrt(distance)));
            }
        }
        return quality;
    }

    private void setMinAndMax(int[][] towers, int[] minXY, int[] maxXY) {
        for (int[] tower : towers) {
            minXY[0] = Math.min(minXY[0], tower[0]);
            minXY[1] = Math.min(minXY[1], tower[1]);
            maxXY[0] = Math.max(maxXY[0], tower[0]);
            maxXY[1] = Math.max(maxXY[1], tower[1]);
        }
    }
}