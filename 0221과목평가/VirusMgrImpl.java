package com.ssafy.corona.virus;

import java.util.Arrays;

public class VirusMgrImpl implements VirusMgr {
	private Virus[] virus;
	private int index;
	
	public VirusMgrImpl() {
		virus=new Virus[100];		
	}
	
	@Override
	public void add(Virus v) throws DuplicatedException{
		try {
			if(search(v.getName())!=null) {
				throw new DuplicatedException(v.getName()+": 등록된 바이러스입니다.");
			}
		} catch (NotFoundException e) {
			virus[index++]=v;
		}
	}
	@Override
	public Virus[] search() {
		int length=0;
		for(int i=0;i<virus.length;i++) {
			if(virus[i]==null) break;
			length++;
		}
		Virus[] temp=Arrays.copyOf(virus, length);
		return temp;
	}
	@Override
	public Virus search(String name) throws NotFoundException{
		for(int i=0; i<virus.length; i++) {
			if(virus[i]!=null && virus[i].getName().equals(name)) return virus[i];
		}
		throw new NotFoundException(name+": 미등록 바이러스입니다.");
	}
}
