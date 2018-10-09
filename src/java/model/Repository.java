/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class Repository {
    private String collaborators;

	private String private_repos;

	private String name;

	private String space;

	public String getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(String collaborators) {
		this.collaborators = collaborators;
	}

	public String getPrivate_repos() {
		return private_repos;
	}

	public void setPrivate_repos(String private_repos) {
		this.private_repos = private_repos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	@Override
	public String toString() {
		return "ClassRepository [collaborators = " + collaborators
				+ ", private_repos = " + private_repos + ", name = " + name
				+ ", space = " + space + "]";
	}
}
