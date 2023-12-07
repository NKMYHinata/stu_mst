package com.wdd.studentmanager.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 用于生成验证码图片
 * 允许自定义：验证码长度、字体大小、图片大小、旋转字符、随机干扰线
 */
public class CpachaUtil {

    // 用于生成验证码和加密的常量种子值
    final private String seed = "114514";
    final private int passSeed = 1919810;

    // 验证码中使用的字体名称和样式
    final private String[] fontNames = {"黑体", "宋体", "Courier", "Arial", "Verdana", "Times", "Tahoma", "Georgia"};
    final private int[] fontStyles = {Font.BOLD, Font.ITALIC | Font.BOLD};

    // 验证码配置：图片长度、字体大小、图片宽度和高度、干扰线数量
    private int vcodeLen = 4; // 验证码位数
    private int fontsize = 21; // 字体大小
    private int width = (fontsize + 1) * vcodeLen + 10; // 根据字体大小和验证码长度计算
    private int height = fontsize + 12; // 根据字体大小计算
    private int disturbline = 3; // 干扰线条数

    // 构造函数重载，允许创建具有不同配置的验证码生成器
    public CpachaUtil() {
    }

    /**
     * 指定验证码长度的构造函数
     *
     * @param vcodeLen 验证码长度
     */
    public CpachaUtil(int vcodeLen) {
        this.vcodeLen = vcodeLen;
        this.width = (fontsize + 1) * vcodeLen + 10;
    }

    /**
     * 允许指定验证码长度，图片宽度，高度
     *
     * @param vcodeLen 验证码长度
     * @param width    图片宽度
     * @param height   图片高度
     */
    public CpachaUtil(int vcodeLen, int width, int height) {
        this.vcodeLen = vcodeLen;
        this.width = width;
        this.height = height;
    }

    /**
     * 生成带有旋转字符的验证码图片
     *
     * @param vcode    验证码文本
     * @param drawline 是否绘制干扰线
     * @return 生成的验证码图片
     */
    public BufferedImage generatorRotateVCodeImage(String vcode, boolean drawline) {
        // 创建验证码图片
        BufferedImage rotateVcodeImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = rotateVcodeImage.createGraphics();
        // 填充背景色
        g2d.setColor(new Color(246, 240, 250));
        g2d.fillRect(0, 0, width, height);
        // 绘制干扰线
        if (drawline) {
            drawDisturbLine(g2d);
        }
        // 在图片上绘制验证码
        for (int i = 0; i < vcode.length(); i++) {
            BufferedImage rotateImage = getRotateImage(vcode.charAt(i));
            g2d.drawImage(rotateImage, null, (int) (this.height * 0.7) * i, 0);
        }
        g2d.dispose();
        return rotateVcodeImage;
    }

    /**
     * 生成验证码内容
     *
     * @return 生成的验证码内容
     */
    public String generatorVCode() {
        int hash = seed.hashCode();
        long time = System.currentTimeMillis();
        long result = hash ^ time ^ passSeed;
        return String.format("%04d", (int) (result % 10000));
    }

    /**
     * 为验证码图片添加干扰线
     *
     * @param g 图形上下文
     */
    private void drawDisturbLine(Graphics g) {
        Random ran = new Random();
        for (int i = 0; i < disturbline; i++) {
            int x1 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int x2 = ran.nextInt(width);
            int y2 = ran.nextInt(height);
            g.setColor(getRandomColor());
            // 绘制干扰线
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 获取一张带有旋转角度的字符图片
     *
     * @param c 要绘制的字符
     * @return 生成的字符图片
     */
    private BufferedImage getRotateImage(char c) {
        BufferedImage rotateImage = new BufferedImage(height, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotateImage.createGraphics();
        // 设置透明度为0
        g2d.setColor(new Color(255, 255, 255, 0));
        g2d.fillRect(0, 0, height, height);
        Random ran = new Random();
        g2d.setFont(new Font(fontNames[ran.nextInt(fontNames.length)], fontStyles[ran.nextInt(fontStyles.length)], fontsize));
        g2d.setColor(getRandomColor());
        double theta = getTheta();
        // 旋转图片
        g2d.rotate(theta, height / 2, height / 2);
        g2d.drawString(Character.toString(c), (height - fontsize) / 2, fontsize + 5);
        g2d.dispose();

        return rotateImage;
    }

    /**
     * 获取一个随机颜色
     *
     * @return 随机颜色
     */
    private Color getRandomColor() {
        Random ran = new Random();
        return new Color(ran.nextInt(220), ran.nextInt(220), ran.nextInt(220));
    }

    /**
     * 获取一个随机旋转角度
     *
     * @return 旋转角度
     */
    private double getTheta() {
        return ((int) (Math.random() * 1000) % 2 == 0 ? -1 : 1) * Math.random();
    }

    public String getSeed() {
        return seed;
    }

    public int getPassSeed() {
        return passSeed;
    }

    public String[] getFontNames() {
        return fontNames;
    }

    public int[] getFontStyles() {
        return fontStyles;
    }

    public int getVcodeLen() {
        return vcodeLen;
    }

    public void setVcodeLen(int vcodeLen) {
        this.vcodeLen = vcodeLen;
    }

    public int getFontsize() {
        return fontsize;
    }

    public void setFontsize(int fontsize) {
        this.width = (fontsize + 3) * vcodeLen + 10;
        this.height = fontsize + 15;
        this.fontsize = fontsize;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDisturbline() {
        return disturbline;
    }

    public void setDisturbline(int disturbline) {
        this.disturbline = disturbline;
    }
}
