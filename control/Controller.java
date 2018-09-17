package control;

import javax.swing.JPanel;

import frames.AudioSelection;
import frames.AudioDisplayFrame;
import frames.DisplayQuestion;
import frames.QuestionFrame;
import frames.RapidFire;
import frames.RapidFireAnswer;
import frames.RapidFireTeamSelection;
import frames.TopicFrame;
import frames.SpectrumRoundFrame;

public class Controller 
{
	public static JPanel welcomeScreen;
	public static JPanel roundSelectionScreen;
	public static JPanel cards;
	public static JPanel standardSelectionScreen;
	public static JPanel questionScreen;
	public static int standard;
	public static int click=0;
	public static JPanel panel;
	public static QuestionFrame qframe;
	public static TopicFrame tframe;
	public static String audio,color;
	public static DisplayQuestion display;
	public static SpectrumRoundFrame spectrumRound;
	public static RapidFireTeamSelection rapidFireTeamSelection;
	public static RapidFire rapidFire;
	public static RapidFireAnswer rapidFireAnswers;
	public static String violet="unselected",indigo="unselected",blue="unselected",green="unselected",yellow="unselected",orange="unselected",red="unselected",white="unselected";
	public static String group;
	public static int time=60;
	public static String speech1="unselected",speech2="unselected",speech3="unselected",speech4="unselected",audio1="unselected",audio2="unselected",audio3="unselected",audio4="unselected";
	public static AudioDisplayFrame audioDisplayFrame;
	public static AudioSelection audioSelection;
}
