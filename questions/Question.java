package questions;

import control.Controller;

public class Question 
{
		public static int counter;
		public static String selectedOption;
		public static String correctOption;
		public static String[][] que_sixth=new String[][] {
			{"Parola fort memorizes us of which freedom fighter ?","Rani Laxmibai"},
			{"The UNESCO world heritage site famous for paintings and Buddhist religious art is ?","Ajanta"},
			{"Swinging Towers are located in Jalgaon district, around 16 km from Erondal, at ?","Farkande"},
			{"Extremely popular poetess of Maharashtra, who is also known as 'KHANDESH KANYA' is ?","Bahinabai"},
			};
			
			public static String[][] opt_sixth=new String[][] {
				{"Veer Sawarkar","Pratibhatai Patil","Ahilyabai Holkar","Rani Laxmibai"},
				{"Ajanta","Chalisgaon","Allora","Erandol"},
				{"Avane","Pahur","Tarsod","Farkande"},
				{"Padmavati","Rani LaxmiBai","Bahinabai","Muktabai"},
				};

		
		public static String[][] que_seventh=new String[][] {
			{"Which city is called as the 'City of Nawabs' ?","Lucknow"},
			{"Which city is called as the 'Golden City of India' ? ","Amritsar"},
			{"Steel city of India is ?","Jamshedpur"},
			{"Switzerland of India is ?","Kashmir"},
			};
		
			public static String[][] opt_seventh=new String[][] {
				{"Lucknow","Bihar","Delhi","Rajasthan"},
				{"Amritsar","Chandigarh","Delhi","Surat"},
				{"Mumbai","Ahmedabad","Kanpur","Jamshedpur"},
				{"Jammu","Kashmir","Darjeeling","Shimla"},
				};
			
		public static String[][] que_eighth=new String[][] {
			{"Who found sea route to India via Cape of Good Hope ?","Vasco Da Gama"},
			{"Olympic gold medalist Abhinav Bindra is associated with which sports ?","Shooting"},
			{"Brightest planet of the solar system is ?","Venus"},
			{"What is the minimum age perscribed to become the President of India ?","35 years"},
			};
		
			public static String[][] opt_eighth=new String[][] {
				{"Roald Amundsen","Nicolaus Copernicus","Marco Polo","Vasco Da Gama"},
				{"Boxing","Wrestling","Archery","Shooting"},
				{"Mercury","Venus","Jupiter","Saturn"},
				{"25 years","30 years","35 years","40 years"},
				};
			
		public static String[][] que_ninth=new String[][] {
			{"Total number of states in India are ?","29"},
			{"Which of the following is a volatile memory ?","RAM"},
			{"Who is the author of the book - WAR AND PEACE ?","Leo Tolstoy"},
			{"First Indian to take a hat-trick in Test cricket is ?","Harbhajan Singh"},
			};
		
			public static String[][] opt_ninth=new String[][] {
				{"27","28","30","29"},
				{"PROM","EPROM","RAM","ROM"},
				{"William Shakespeare","VS Naipaul","Vikram Seth","Leo Tolstoy"},
				{"Harbhajan Singh","Kapil Dev","Chetan Sharma","Javagal Srinath"},
				};
			
		public static String[][] que_tenth=new String[][] {
			{"Indira Gandhi international airport is located at ?","New Delhi"},
			{"Which of the following is the biggest sea animal ?","Blue Whale"},
			{"Who was popularly known as Netaji ?","Subhash Chandra Bose"},
			{"Who is the author of the book - Broken Wing ?","Sarojini Naidu"},
			};
		
			public static String[][] opt_tenth=new String[][] {
				{"New Delhi","Mumbai","Chennai","Karnataka"},
				{"Dolphin","Blue Whale","Shark","Penguin"},
				{"Vallabhai Patel","Bal Gangadhar Tilak","Jawaharlal Nehru","Subhash Chandra Bose"},
				{"Mahatma Gandhi","Annie Besant","Sarojini Naidu","Dadhabhai Naoroji"},
				};
				
		public static String[][] queGrpOne=new String[][] {
			{"What do astronomers refer to as 'dirty snowball' ?","Comet\n"},
			{"Which animal orient themselves with ultrasonic sound ?","Bats\n"},
			{"What is arithmophobia ?","Fear of numbers"},
			{"Name the circle which touches all three vertices of a triangle ?","Circumcircle\n"},
			{"Who wrote Manifest of Communism ?","Karl Marx and Fedrick Engles"},
			{"The world's oldest known city is ?","Damascus"},
			{"The longest river in the world is ?","Nile"},
			{"Greta Garbo is associated with ?","Acting"},
			{"What is the unit of pressure ?","Pascal"},
			{"Who is the composer of 'Sare Jahan Se Accha' ?","Eqbal"},
			{"What is the full form of BARC ?","Bhabha Atomic Research Center"},
			{"What is the Theme of March month in our school ?","My success-My hardwork to smart work"},
		};
		
		public static String[][] queGrpTwo=new String[][] {
			{"Europe is the moon of which planet ?","Jupiter"},
			{"In what way do bears save energy ?","Hibernation"},
			{"Which place is called as the Big Apple ?","New York"},
			{"Name the point of concurrence of perpendicular bisectors of sides of a triangle ?","Orthocentre\n"},
			{"'Adventures of Tom Sawyer' is written by ?","Mark Twain"},
			{"The city which is also known as the 'City of Canals' is ?","Venice\n"},
			{"The biggest desert in the world is ?","Sahara Desert"},
			{"Musical instrument played by Amjad Ali Khan ?","Sarod"},
			{"What is the unit of magnetic field ?","Tesla"},
			{"Who is the singer of the song 'Mere Vatan Ke Logo' ?","Lata Mangeshkar\n"},
			{"What is the full form of TIFR ?","Tata Institute of Fundamental Research"},
			{"What is the motto of our school ?","Life in fullness"},
		};
		
		public static String[][] queGrpThree=new String[][] {
			{"An 'Optical Instrument' which is used to see the stars in the night sky ?","Telescope\n"},
			{"Other name given to degradation of weathered rock ?","Erosion\n"},
			{"Name the largest delta in the world ?","Ganges Delta"},
			{"Area of square ?","Side squared"},
			{"The river which carries maximum quantity of water ?","Amazon\n"},
			{"The largest coffee growing country in the world is ?","Brazil\n"},
			{"'The Lady with the Lamp' was the name given to ?","Florence Nightingale\n"},
			{"SI unit of luminous intensity ?","Candella"},
			{"Who is the author of Mein Kampf ?","Adolf Hitler"},
			{"Who is the writer of Vande Mataram ?","Bankin Chandra Chattopadhyay"},
			{"What is the full form of ISRO ?","Indian Space Research Center"},
			{"What does the symbol of 'HANDS' in our school emblem represent ?","Utmost Care"},
		};
		
		public static String[][] queGrpFour=new String[][] {
			{"In which phase is the moon not visible ?","New Moon"},
			{"Which earth era did the first fossil findings belong to ?","Cambrian\n"},
			{"Full form of FIFA ?",""},
			{"Author of 'Das Captial' ?","Karl Marx"},
			{"The city, which is the biggest centre for manufacturing of automobiles ?","Detroit,USA\n"},
			{"The country which is known as 'Country of Copper' ?","Zambia\n"},
			{"The scientist well known for his theory of relativity ?","Albert Einstein\n"},
			{"What is the unit of frequency ?","Hertz"},
			{"Who has written our National Anthem ?","Rabindranath Tagore"},
			{"What is the full form of NCC ?","National Cadet Corps"},
			{"The year in which CMC congregation was founded ?","1866\n"},
			{"The line which touches the circle in one and only one point is ?","Tangent\n"},
		};
		
			
		public static boolean checkAnswer()
		{
			if(Controller.standard==6)
			{
				if(que_sixth[Question.counter][1].equals(selectedOption))
				{
					return true;
				}
				else
				{
					Question.correctOption=que_sixth[Question.counter][1];
					return false;
				}
					
			}
			else if(Controller.standard==7)
			{
				if(que_seventh[Question.counter][1].equals(selectedOption))
				{
					
					return true;
				}
				else
				{
					Question.correctOption=que_seventh[Question.counter][1];
					return false;
				}
					
			}
			else if(Controller.standard==8)
			{
				if(que_eighth[Question.counter][1].equals(selectedOption))
				{
					return true;
				}
				else
				{
					Question.correctOption=que_eighth[Question.counter][1];
					return false;
				}
			}
			else if(Controller.standard==9)
			{
				if(que_ninth[Question.counter][1].equals(selectedOption))
				{
					return true;
				}
				else
				{
					Question.correctOption=que_ninth[Question.counter][1];
					return false;
				}
					
			}
			else if(Controller.standard==10)
			{
				if(que_tenth[Question.counter][1].equals(selectedOption))
				{
					return true;
				}
				else
				{
					Question.correctOption=que_tenth[Question.counter][1];	
					return false;	
				}
				
			}
			else return false;
		}

}
