package com.company.target.pattern.ch12.combined.djview;

/**
 * 打击音乐
 */
public interface BeatModelInterface {

	/**
	 * 初始化
	 */
	void initialize();

	/**
	 * 开
	 */
	void on();

	/**
	 * 关
	 */
	void off();

	/**
	 * 设置节拍数
	 * 
	 * @param bpm
	 */
	void setBPM(int bpm);

	/**
	 * 获取当前节拍
	 * 
	 * @return
	 */
	int getBPM();

	/**
	 * 注册观察者
	 * 
	 * @param o
	 */
	void registerObserver(BeatObserver o);

	/**
	 * 移除某个观察者
	 * 
	 * @param o
	 */
	void removeObserver(BeatObserver o);

	/**
	 * 注册观察者
	 * 
	 * @param o
	 */
	void registerObserver(BPMObserver o);

	/**
	 * 移除某个观察者
	 * 
	 * @param o
	 */
	void removeObserver(BPMObserver o);

}
