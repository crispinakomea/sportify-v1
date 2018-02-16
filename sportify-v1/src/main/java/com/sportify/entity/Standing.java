package com.sportify.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Crispin A.
 *
 */
@Entity
@Table(name = "STANDINGS")
public class Standing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private int P;
	private int W;
	private int D;
	private int L;
	private int GF;
	private int GA;
	private int GD;

	public Standing() {

	}

	public Standing(int id, String name, int p, int w, int d, int l, int gF, int gA, int gD) {
		this.id = id;
		this.name = name;
		P = p;
		W = w;
		D = d;
		L = l;
		GF = gF;
		GA = gA;
		GD = gD;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getP() {
		return P;
	}

	public void setP(int p) {
		P = p;
	}

	public int getW() {
		return W;
	}

	public void setW(int w) {
		W = w;
	}

	public int getD() {
		return D;
	}

	public void setD(int d) {
		D = d;
	}

	public int getL() {
		return L;
	}

	public void setL(int l) {
		L = l;
	}

	public int getGF() {
		return GF;
	}

	public void setGF(int gF) {
		GF = gF;
	}

	public int getGA() {
		return GA;
	}

	public void setGA(int gA) {
		GA = gA;
	}

	public int getGD() {
		return GD;
	}

	public void setGD(int gD) {
		GD = gD;
	}

	@Override
	public String toString() {
		return "Standing [id=" + id + ", name=" + name + ", P=" + P + ", W=" + W + ", D=" + D + ", L=" + L + ", GF="
				+ GF + ", GA=" + GA + ", GD=" + GD + "]";
	}

}
