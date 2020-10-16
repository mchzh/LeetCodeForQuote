class Solution {
    // binary search
    // text is displayed on a single line
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        //Arrays.sort(fonts);
        int left = 0, right = fonts.length-1;
        while (left < right) {
            int mid = right - (right-left) / 2;
            
            if (isOk(text, w, h, fonts[mid], fontInfo)) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        if (isOk(text, w, h, fonts[left], fontInfo)) return fonts[left];
        else return -1;
    }
    private boolean isOk(String text, int w, int h, int fontSize, FontInfo fontInfo) {
        int hdis = fontInfo.getHeight(fontSize);
        if (h < hdis) return false;
        int levelWid = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            
            int curWid = fontInfo.getWidth(fontSize, c);
            if (curWid + levelWid > w) return false;
            levelWid += curWid;
        }
        return true;
    }
}
