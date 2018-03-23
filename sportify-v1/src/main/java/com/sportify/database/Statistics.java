package com.sportify.database;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;

import com.opencsv.CSVReader;
import com.sportify.entity.League;
import com.sportify.entity.Statistic;
import com.sportify.utility.HibernateUtil;
import com.sportify.utility.HttpUtil;

/**
 * @author Crispin A.
 *
 */
public class Statistics {

	private static Statistics singleInstance = null;

	private Statistics() {

	}

	public static Statistics getInstance() {
		if (singleInstance == null) {
			synchronized (Statistics.class) {
				if (singleInstance == null) {
					singleInstance = new Statistics();
				}
			}
		}
		return singleInstance;
	}

	/**
	 * 
	 * Updates the statistics in the database of the league passed as argument.
	 * 
	 * @param league
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void update(Object league) throws MalformedURLException, IOException {
		String division = ((League) league).getDivision();
		String url = "http://www.football-data.co.uk/mmz4281/1718/" + division + ".csv";
		String file = "src/main/resources/tmp/" + division + ".csv";
		HttpUtil.downloadFile(url, file);
		Statistic statistic = null;
		try (CSVReader reader = new CSVReader(new FileReader(file))) {
			String[] nextLine;
			reader.readNext();
			while ((nextLine = reader.readNext()) != null) {
				if (!nextLine[4].equals("") || !nextLine[5].equals("") || !nextLine[6].equals("")) {
					statistic = makeStatistic(nextLine, ((League) league));
					HibernateUtil.save(statistic);
				}
			}
		}
		FileUtils.forceDelete(new File(file));
	}

	private Statistic makeStatistic(String[] nextLine, League league) {
		Statistic statistic = new Statistic();
		statistic.setLeague(league);
		statistic.setDate(nextLine[1]);
		statistic.setHomeTeam(nextLine[2]);
		statistic.setAwayTeam(nextLine[3]);
		statistic.setFTHG(Integer.parseInt(nextLine[4]));
		statistic.setFTAG(Integer.parseInt(nextLine[5]));
		statistic.setFTR(nextLine[6].charAt(0));
		statistic.setHTHG(Integer.parseInt(nextLine[7]));
		statistic.setHTAG(Integer.parseInt(nextLine[8]));
		statistic.setHTR(nextLine[9].charAt(0));
		statistic.setReferee(nextLine[10]);
		return statistic;
	}

}