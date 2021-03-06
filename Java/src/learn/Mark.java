package learn;

public class Mark {
	private float Math;
	private float History;
	private float MarkAVG;
	
	public Mark() {}
	
	public Mark(float Math, float History) {
		this.SetHistory(History);
		this.SetMath(Math);
		this.SetMarkAVG();
	}
	
	public float GetMath() {
		return this.Math;
	}
	
	public float GetHistory() {
		return this.History;
	}
	
	public float GetMarkAVG() {
		return this.MarkAVG;
	}
	
	public void SetMath(float Math) {
		this.Math = Math;
	}
	
	public void SetHistory(float History) {
		this.History = History;
	}
	
	public void SetMarkAVG() {
		this.MarkAVG = (this.History + this.Math) / 2;
	}
}
