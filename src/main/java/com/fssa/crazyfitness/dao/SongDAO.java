package com.fssa.crazyfitness.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.crazyfitness.dao.exceptions.DAOException;
import com.fssa.crazyfitness.model.Song;
import com.fssa.crazyfitness.util.ConnectionDb;
import com.fssa.crazyfitness.util.DatabaseException;

public class SongDAO {

	public boolean createSong(Song song) throws DAOException {
		String insertQuery = "INSERT INTO song (song_id, song_name, song_image, song_url) VALUES(?,?,?,?)";
		String selectQuery = "SELECT song_id FROM song WHERE song_id = ?";
		try (Connection connect = ConnectionDb.getConnection();
				PreparedStatement selectPst = connect.prepareStatement(selectQuery);
				PreparedStatement insertPst = connect.prepareStatement(insertQuery)) {
			selectPst.setInt(1, song.getSongId());
			ResultSet rs = selectPst.executeQuery();
			if (rs.next()) {
				rs.close();
				return false;
			}
			rs.close();

			insertPst.setInt(1, song.getSongId());
			insertPst.setString(2, song.getSongName());
			insertPst.setString(3, song.getSongImage());
			insertPst.setString(4, song.getSongUrl());
			int rows = insertPst.executeUpdate();
			return (rows == 1);
		} catch (SQLException  e) {
			throw new DAOException(e);
		}
	}
}