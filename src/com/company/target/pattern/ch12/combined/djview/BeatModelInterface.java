package com.company.target.pattern.ch12.combined.djview;

/**
 * �������
 */
public interface BeatModelInterface {

	/**
	 * ��ʼ��
	 */
	void initialize();

	/**
	 * ��
	 */
	void on();

	/**
	 * ��
	 */
	void off();

	/**
	 * ���ý�����
	 * 
	 * @param bpm
	 */
	void setBPM(int bpm);

	/**
	 * ��ȡ��ǰ����
	 * 
	 * @return
	 */
	int getBPM();

	/**
	 * ע��۲���
	 * 
	 * @param o
	 */
	void registerObserver(BeatObserver o);

	/**
	 * �Ƴ�ĳ���۲���
	 * 
	 * @param o
	 */
	void removeObserver(BeatObserver o);

	/**
	 * ע��۲���
	 * 
	 * @param o
	 */
	void registerObserver(BPMObserver o);

	/**
	 * �Ƴ�ĳ���۲���
	 * 
	 * @param o
	 */
	void removeObserver(BPMObserver o);

}
