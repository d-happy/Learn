package puzzle_3_alone;

public class GameManager implements Result_NumberPuzzle{
	
	private static GameManager instance;
	private GameManager() {/* singleton */}
	public static GameManager getinstance() {
		if (instance == null) {
			instance = new GameManager();
		}
		return instance;
	} //static Ŭ���� �������� ��ü 1���� ����ϴϱ� ����?!
	
	private final int COUNTAll = 5;
	private int lifeCount = 0;
	private int numberRandom = 0; //�ϴ� 0���� ����
	
	
	public void gameStart() {
		lifeCount = COUNTAll;
		numberRandom = ((int)(Math.random()*100)+1);
	}
	
	public void gameNew() {
		lifeCount = COUNTAll;
		numberRandom = ((int)(Math.random()*100)+1);
	}
	
	public int numResult(int numberUser) {
		int result = 0;
		
		if (0 <= lifeCount && lifeCount <= COUNTAll) {
			if (numberUser > numberRandom) {
				result = BIG;
			} else if (numberUser < numberRandom) {
				result = SMALL;
			} else if (numberUser == numberRandom) {
				result = SAME;
			}
		} else if (lifeCount < 0) {
			result = COUNT_MINUS;
		}
		return result;
	}
	
	
	public int getLifeCount() {
		return lifeCount;
	}
	public void setLifeCount(int lifeCount) {
		this.lifeCount = lifeCount;
	}
	public int getNumberRandom() {
		return numberRandom;
	}
	public void setNumberRandom(int numberRandom) {
		this.numberRandom = numberRandom;
	}
	
}//class
