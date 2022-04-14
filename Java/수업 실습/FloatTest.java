
public class FloatTest {

	public static void main(String[] args) {
		int int1 = 7;
		int int2 = 44;
		int int3, int4, int5;
		float float1, float2, float3;
		
		int3 = int2 * int1;
		//int4 = int2 / int1;
		float1 = int2 / int1;
		float2 = (float)int2 / int1;
		//int5 = 44 / int1;
		float3 = 44 / (float)int1;
		
		System.out.println("44 * 7 = " + int3);
		//System.out.println("44 / 7 = " + int4);
		System.out.println("44 / 7 = " + float1);
		System.out.println("44 / 7 = " + float2);
		//System.out.println("44 / 7 = " + int5);
		System.out.println("44 / 7 = " + float3);

	}

}
