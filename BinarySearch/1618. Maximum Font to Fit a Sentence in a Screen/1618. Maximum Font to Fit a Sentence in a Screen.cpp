class Solution {
public:
    int maxFont(string text, int w, int h, vector<int>& fonts, FontInfo fontInfo) {
        int left = 0, right = fonts.size()-1;
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
    bool isOk(string text, int w, int h, int fontSize, FontInfo fontInfo) {
        int hdis = fontInfo.getHeight(fontSize);
        if (h < hdis) return false;
        int levelWid = 0;
        for (int i = 0; i < text.length(); i++) {
            int curWid = fontInfo.getWidth(fontSize, text[i]);
            if (curWid + levelWid > w) return false;
            levelWid += curWid;
        }
        return true;
    }
};
