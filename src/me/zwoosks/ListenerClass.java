package me.zwoosks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import disponibility.Sumo1Manager;

public class ListenerClass implements Listener {
	
	MainClass configGetter;
	
	int countdown = 11;
	int count;
	
	int countdown2 = 6;
	int count2;
	
	public ListenerClass(MainClass plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		configGetter = plugin;
	}
	
	
	@EventHandler
	public void signListener(PlayerInteractEvent e) {
		
		deb("1");
		
		try {
			
			if(e.getClickedBlock().getState() instanceof Sign) {
				
				deb("2");
				
				Sign sign = (Sign) e.getClickedBlock().getState();
				
				Player player = (Player) e.getPlayer();
				
				String line0 = ChatColor.stripColor(sign.getLine(0));
				
				Location location = sign.getLocation();
				configGetter.getConfig().set("test", location);
				configGetter.saveConfig();
				
				if(line0.equalsIgnoreCase("[SUMO #1]")) {
					
					deb("3");
					
					World world = configGetter.getServer().getWorld("sumoArena1");
					int players = world.getPlayers().size();
					
					player.sendMessage(Integer.toString(players));
					
					boolean p1 = Sumo1Manager.puesto1;
					boolean p2 = Sumo1Manager.puesto2;
					boolean p3 = Sumo1Manager.puesto3;
					boolean p4 = Sumo1Manager.puesto4;
					
//					if(p1) {
						
						// Entonces puede entrar
						
						if(Sumo1Manager.isDisponible) {
							
							deb("4");
							
							if(p1) {
								
								deb("5");
								
								world.setPVP(false);
								
								Sumo1Manager.setPuesto1(false);
								Sumo1Manager.setPerson1(player.getName());
								
								// Cambiar gamemode
								player.setGameMode(GameMode.ADVENTURE);
								
								
								// Tp primer bloque
								player.teleport(new Location(world, 1.5, 61.5, -11.5));
								
								
								// Updating carteles
								sign.setLine(1, world.getPlayers().size() + "/4");
								sign.update();
								
								// Check
								
								debug("debug - p1 if sentence - players: " + players);
								
								if(players == 3) {
									
									deb("6");
									
									Sumo1Manager.setDisponible(false);
									
									sign.setLine(1, "4/4");
									sign.setLine(2, ChatColor.RED + "JUGANDO");
									sign.update();
									
									// Contador
									try {
										contador(world);
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										System.out.println("error al metodo privado contador de ListenerClass");
									}
									
								} else {
									
									deb("7");
									
									Sumo1Manager.setDisponible(true);
									
								}
								
								
								
								
								
							} else if(p2) {
								
								deb("8");
								
								world.setPVP(false);
								
								Sumo1Manager.setPuesto2(false);
								Sumo1Manager.setPerson2(player.getName());
								
								// Cambiar gamemode
								player.setGameMode(GameMode.ADVENTURE);
								
								
								// Tp primer bloque
								player.teleport(new Location(world, 12.5, 61.5, -0.5, 90, 0));
								
								
								// Updating carteles
								sign.setLine(1, 2 + "/4");
								sign.update();
								
								if(players == 3) {
									
									deb("9");
									
									Sumo1Manager.setDisponible(false);
									
									sign.setLine(1, "4/4");
									sign.setLine(2, ChatColor.RED + "JUGANDO");
									sign.update();
									
									// Contador
									try {
										contador(world);
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										System.out.println("error al metodo privado contador de ListenerClass");
									}
									
								} else {
									
									deb("10");
									
									Sumo1Manager.setDisponible(true);
									
								}
								
							} else if(p3) {
								
								deb("11");
								
								world.setPVP(false);
								
								Sumo1Manager.setPuesto3(false);
								Sumo1Manager.setPerson3(player.getName());
								
								// Cambiar gamemode
								player.setGameMode(GameMode.ADVENTURE);
								
								
								// Tp primer bloque
								player.teleport(new Location(world, -9.5, 61.5, -0.5, -90, 0));
								
								
								// Updating carteles
								sign.setLine(1, world.getPlayers().size() + "/4");
								sign.update();
								
								if(players == 3) {
									
									deb("12");
									
									Sumo1Manager.setDisponible(false);
									
									sign.setLine(1, "4/4");
									sign.setLine(2, ChatColor.RED + "JUGANDO");
									sign.update();
									
									// Contador
									try {
										contador(world);
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										System.out.println("error al metodo privado contador de ListenerClass");
									}
									
								} else {
									
									deb("13");
									
									Sumo1Manager.setDisponible(true);
									
								}
								
							} else if(p4) {
								
								deb("14");
								
								world.setPVP(false);
								
								Sumo1Manager.setPuesto4(false);
								Sumo1Manager.setPerson4(player.getName());
								
								// Cambiar gamemode
								player.setGameMode(GameMode.ADVENTURE);
								
								
								// Tp primer bloque
								player.teleport(new Location(world, 1.5, 61.5, 10.5, 180, 0));
								
								if(players == 3) {
									
									deb("15");
									
									Sumo1Manager.setDisponible(false);
									
									sign.setLine(1,"4/4");
									sign.setLine(2, ChatColor.RED + "JUGANDO");
									sign.update();
									
									// Contador
									try {
										contador(world);
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										System.out.println("error al metodo privado contador de ListenerClass");
									}
									
								} else {
									
									deb("16");
									
									Sumo1Manager.setDisponible(true);
									
								}
								
								
							} else {
								
								deb("17");
								
								player.sendMessage(ChatColor.GREEN + "¡La arena ya está llena!");
								
							}
							
						} else {
							
							deb("18");
							
							player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "¡La partida ya está en juego!");
							
						}
						
//					} else {
//						
//						player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "¡La partida ya está en juego!");
//						
//						debug("tercer missatge de no disponible");
//						
//					}
					
				}
				
			}
			
		} catch(Exception ex) {
			
			
			
		}
		
	}
	
	@EventHandler
	public void onFall(EntityDamageEvent e) {
		
		deb("19");
		
		if(e.getEntity().getWorld().getName().equalsIgnoreCase("Lobby")) {
			
			deb("20");
			
			if(e.getEntity().getLocation().getY() > 0) {
				
				deb("21");
				
				e.setCancelled(true);
				
			}
			
		} else if(e.getEntity().getWorld().getName().equalsIgnoreCase("sumoArena1")) {
			
			if(e.getEntity() instanceof Player) {
				
				Player player = (Player) e.getEntity();
				
				player.setHealth(20);
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onTeleport(PlayerTeleportEvent e) {
		
		deb("22");
		
		if(e.getFrom().getWorld().getName().equalsIgnoreCase("sumoArena1") && !(e.getTo().getWorld().getName().equalsIgnoreCase("sumoArena1"))) {
			
			deb("23");
			
			Location loc = (Location) configGetter.getConfig().get("cartel1");
			
			Sign sign = (Sign) loc.getBlock().getState();
			
			int players = e.getPlayer().getWorld().getPlayers().size();
			
			
			String per1 = Sumo1Manager.person1;
			String per2 = Sumo1Manager.person2;
			String per3 = Sumo1Manager.person3;
			String per4 = Sumo1Manager.person4;
			
			String playerName = e.getPlayer().getName();
			
			boolean is1 = per1.equalsIgnoreCase(playerName);
			boolean is2 = per2.equalsIgnoreCase(playerName);
			boolean is3 = per3.equalsIgnoreCase(playerName);
			boolean is4 = per4.equalsIgnoreCase(playerName);
			
			
			if(players == 2) {
				
				deb("24");
				
				Player player1 = e.getPlayer().getWorld().getPlayers().get(0);
				String player1Name = e.getPlayer().getWorld().getPlayers().get(0).getName();
				
				Player player2 = e.getPlayer().getWorld().getPlayers().get(1);
				String player2Name = e.getPlayer().getWorld().getPlayers().get(1).getName();
				
				if(playerName.equalsIgnoreCase(player1Name)) {
					
					deb("25");
					
					Sumo1Manager.setWhoWon(player2Name);
					
					// Broadcast qui ha gunyat - en aquest cas l'altre
					Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "¡" + player2Name + " ha ganado en [SUMO #1]!");
					
					Sumo1Manager.setWhoWon("");
					
					try {
						contador2(player2);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} else if(playerName.equalsIgnoreCase(player2Name)) {
					
					if(!(Sumo1Manager.isDisponible)) {
						
						deb("26");
						
						Sumo1Manager.setWhoWon(player1Name);
						
						// Broadcast qui ha gunyat - en aquest cas l'altre
						Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "¡" + player1Name + " ha ganado en [SUMO #1]!");
						
						Sumo1Manager.setWhoWon("");
						
						try {
							contador2(player1);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
				}
				
				
				
			}
			
			
			if(is1) {
				
				deb("27");
				
				Sumo1Manager.setPuesto1(true);
				
				sign.setLine(1, players -1 + "/4");
				sign.update();
				
			} else if(is2) {
				
				deb("28");
				
				Sumo1Manager.setPuesto2(true);
				
				sign.setLine(1, players -1 + "/4");
				sign.update();
				
			} else if(is3) {
				
				deb("29");
				
				Sumo1Manager.setPuesto3(true);
				
				sign.setLine(1, players -1 + "/4");
				sign.update();
				
			} else if(is4) {
				
				deb("30");
				
				Sumo1Manager.setPuesto4(true);
				
				sign.setLine(1, players -1 + "/4");
				sign.update();
				
			}
			
			if(e.getFrom().getWorld().getPlayers().size()-1 == 0) {
				
				deb("31");
				
				Sumo1Manager.setDisponible(true);
				
				sign.setLine(1, "0/4");
				sign.setLine(2, ChatColor.GREEN + "DISPONIBLE");
				sign.update();
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onFall(PlayerMoveEvent e) {
		
		if(e.getTo().getWorld().getName().equalsIgnoreCase("sumoArena1")) {
			
			if(!(e.getPlayer().getName().equalsIgnoreCase(Sumo1Manager.whoWon))) {
				
				if(e.getTo().getY() == 56) {
					
					deb("34");
					
					e.getPlayer().teleport(new Location(configGetter.getServer().getWorld("Lobby"), 0.5, 157, 0.5));
					
				}
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onPlayerDisconnectEvent(PlayerQuitEvent e) {
		
		deb("35");
		
		Player player = e.getPlayer();
		
		// TP to lobby
		
		player.teleport(new Location(Bukkit.getWorld("Lobby"), 0.5, 157, 0.5));
		
	}
	
	private void contador(World world) throws InterruptedException {
		
		// Posar blocs
		
		World blockWorld = Bukkit.getWorld("sumoArena1");
		
				// Una pos
				Location loc1 = new Location(blockWorld, 3, 62, -1);
				Location loc2 = new Location(blockWorld, 4, 62, -2);
				Location loc3 = new Location(blockWorld, 5, 62, -1);
				Location loc4 = new Location(blockWorld, 4, 62, 0);
				
				loc1.getBlock().setType(Material.BARRIER);
				loc2.getBlock().setType(Material.BARRIER);
				loc3.getBlock().setType(Material.BARRIER);
				loc4.getBlock().setType(Material.BARRIER);
		
				// Una pos
				Location loc5 = new Location(blockWorld, 1, 62, 1);
				Location loc6 = new Location(blockWorld, 2, 62, 2);
				Location loc7 = new Location(blockWorld, 1, 62, 3);
				Location loc8 = new Location(blockWorld, 0, 62, 2);
				
				loc5.getBlock().setType(Material.BARRIER);
				loc6.getBlock().setType(Material.BARRIER);
				loc7.getBlock().setType(Material.BARRIER);
				loc8.getBlock().setType(Material.BARRIER);
				
				
				// Una pos
				Location loc9 = new Location(blockWorld, -1, 62, 1);
				Location loc10 = new Location(blockWorld, -2, 62, 0);
				Location loc11 = new Location(blockWorld, -3, 62, -1);
				Location loc12 = new Location(blockWorld, -2, 62, -2);
				
				loc9.getBlock().setType(Material.BARRIER);
				loc10.getBlock().setType(Material.BARRIER);
				loc11.getBlock().setType(Material.BARRIER);
				loc12.getBlock().setType(Material.BARRIER);
				
				
				// Una pos
				Location loc13 = new Location(blockWorld, 1, 62, -3);
				Location loc14 = new Location(blockWorld, 0, 62, -4);
				Location loc15 = new Location(blockWorld, 1, 62, -5);
				Location loc16 = new Location(blockWorld, 2, 62, -4);
				
				loc13.getBlock().setType(Material.BARRIER);
				loc14.getBlock().setType(Material.BARRIER);
				loc15.getBlock().setType(Material.BARRIER);
				loc16.getBlock().setType(Material.BARRIER);
				
		
		
		
		// Jugador 1
		world.getPlayers().get(0).teleport(new Location(world, 1.5, 61, -3.5, 0, 0));
		
		// Jugador 2
		world.getPlayers().get(1).teleport(new Location(world, 4.5, 61, -0.5, 90, 0));
		
		// Jugador 3
		world.getPlayers().get(2).teleport(new Location(world, -1.5, 61, -0.5, -90, 0));
		
		// Jugador 4
		world.getPlayers().get(3).teleport(new Location(world, 1.5, 61, 2.5, 180, 0));
		
		count = Bukkit.getScheduler().scheduleSyncRepeatingTask(configGetter, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				if(countdown > 0) {
					
					deb("36");
					
					countdown--;
					
					for(Player player : world.getPlayers()) {
						
						player.sendMessage(ChatColor.GREEN + "Empezando en " + countdown + " segundos.");
						
					}
					
				} else {
					
					deb("37");
					
					// Treure blocs
					
					World blockWorld = Bukkit.getWorld("sumoArena1");
					
							// Una pos
							Location loc1 = new Location(blockWorld, 3, 62, -1);
							Location loc2 = new Location(blockWorld, 4, 62, -2);
							Location loc3 = new Location(blockWorld, 5, 62, -1);
							Location loc4 = new Location(blockWorld, 4, 62, 0);
							
							loc1.getBlock().setType(Material.AIR);
							loc2.getBlock().setType(Material.AIR);
							loc3.getBlock().setType(Material.AIR);
							loc4.getBlock().setType(Material.AIR);
					
							// Una pos
							Location loc5 = new Location(blockWorld, 1, 62, 1);
							Location loc6 = new Location(blockWorld, 2, 62, 2);
							Location loc7 = new Location(blockWorld, 1, 62, 3);
							Location loc8 = new Location(blockWorld, 0, 62, 2);
							
							loc5.getBlock().setType(Material.AIR);
							loc6.getBlock().setType(Material.AIR);
							loc7.getBlock().setType(Material.AIR);
							loc8.getBlock().setType(Material.AIR);
							
							
							// Una pos
							Location loc9 = new Location(blockWorld, -1, 62, 1);
							Location loc10 = new Location(blockWorld, -2, 62, 0);
							Location loc11 = new Location(blockWorld, -3, 62, -1);
							Location loc12 = new Location(blockWorld, -2, 62, -2);
							
							loc9.getBlock().setType(Material.AIR);
							loc10.getBlock().setType(Material.AIR);
							loc11.getBlock().setType(Material.AIR);
							loc12.getBlock().setType(Material.AIR);
							
							
							// Una pos
							Location loc13 = new Location(blockWorld, 1, 62, -3);
							Location loc14 = new Location(blockWorld, 0, 62, -4);
							Location loc15 = new Location(blockWorld, 1, 62, -5);
							Location loc16 = new Location(blockWorld, 2, 62, -4);
							
							loc13.getBlock().setType(Material.AIR);
							loc14.getBlock().setType(Material.AIR);
							loc15.getBlock().setType(Material.AIR);
							loc16.getBlock().setType(Material.AIR);
					
					
					for(Player player : world.getPlayers()) {
						
						player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "¡La partida ha empezado!");
						
					}
					
					world.setPVP(true);
					Bukkit.getScheduler().cancelTask(count);
					countdown = 11;
					
				}
				
			}
		}, 0, 20);
		
	}
	
	// CONTADOR DE PARTIDA GANADA
	
	private void contador2(Player winner) throws InterruptedException {
		
		count2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(configGetter, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				if(countdown2 > 0) {
					
					deb("38");
					
					countdown2--;
					
					winner.sendMessage(ChatColor.DARK_BLUE + "Volviendo al Lobby en " + countdown2 + " segundos.");
					
				} else {
					
					deb("39");
					
					winner.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Volviendo al Lobby.");
					winner.teleport(new Location(Bukkit.getWorld("Lobby"), 0.5, 157, 0.5));
					
					
					
					
					// UPDATE CARTELL
					
					Location loc = (Location) configGetter.getConfig().get("cartel1");
					
					Sign sign = (Sign) loc.getBlock().getState();
					
					sign.setLine(1, "0/4");
					sign.setLine(2, ChatColor.GREEN + "DISPONIBLE");
					sign.update();
					
					Sumo1Manager.setDisponible(true);
					
					Sumo1Manager.setPuesto1(true);
					Sumo1Manager.setPuesto2(true);
					Sumo1Manager.setPuesto3(true);
					Sumo1Manager.setPuesto4(true);
					
					Bukkit.getScheduler().cancelTask(count2);
					countdown2 = 6;
					
				}
				
			}
		}, 0, 20);
		
	}
	
	
	
	
	private void debug(String message) {
		
		Bukkit.broadcastMessage(message);
		
	}
	
	private void deb(String message) {
		
		Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + message);
		
	}



}
