package batfish.representation.cisco;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import batfish.main.BatfishException;
import batfish.representation.Ip;
import batfish.representation.Protocol;

public class BgpProcess implements Serializable {

   private static final long serialVersionUID = 1L;
   private Map<BgpNetwork, Boolean> _aggregateNetworks;
   private Map<String, BgpPeerGroup> _allPeerGroups;
   private Ip _clusterId;
   private boolean _defaultNeighborActivate;
   private Map<Ip, IpBgpPeerGroup> _ipPeerGroups;
   private MasterBgpPeerGroup _masterBgpPeerGroup;
   private Map<String, NamedBgpPeerGroup> _namedPeerGroups;
   private Set<BgpNetwork> _networks;
   private int _pid;
   private Map<Protocol, BgpRedistributionPolicy> _redistributionPolicies;
   private Ip _routerId;

   public BgpProcess(int procnum) {
      _pid = procnum;
      _allPeerGroups = new HashMap<String, BgpPeerGroup>();
      _namedPeerGroups = new HashMap<String, NamedBgpPeerGroup>();
      _ipPeerGroups = new HashMap<Ip, IpBgpPeerGroup>();
      _networks = new LinkedHashSet<BgpNetwork>();
      _defaultNeighborActivate = true;
      _aggregateNetworks = new HashMap<BgpNetwork, Boolean>();
      _redistributionPolicies = new EnumMap<Protocol, BgpRedistributionPolicy>(
            Protocol.class);
      _masterBgpPeerGroup = new MasterBgpPeerGroup();
   }

   public void addIpPeerGroup(Ip ip) {
      IpBgpPeerGroup pg = new IpBgpPeerGroup(ip);
      pg.setActive(_defaultNeighborActivate);
      _ipPeerGroups.put(ip, pg);
      _allPeerGroups.put(ip.toString(), pg);
   }

   public void addNamedPeerGroup(String name) {
      NamedBgpPeerGroup pg = new NamedBgpPeerGroup(name);
      _namedPeerGroups.put(name, pg);
      _allPeerGroups.put(name, pg);
   }

   public void addPeerGroupMember(Ip address, String namedPeerGroupName) {
      NamedBgpPeerGroup namedPeerGroup = _namedPeerGroups
            .get(namedPeerGroupName);
      if (namedPeerGroup != null) {
         namedPeerGroup.addNeighborAddress(address);
         IpBgpPeerGroup ipPeerGroup = _ipPeerGroups.get(address);
         if (ipPeerGroup == null) {
            addIpPeerGroup(address);
            ipPeerGroup = _ipPeerGroups.get(address);
         }
         ipPeerGroup.setGroupName(namedPeerGroupName);
      }
      else {
         throw new BatfishException("Peer group: \"" + namedPeerGroupName
               + "\" does not exist!");
      }
   }

   public Map<BgpNetwork, Boolean> getAggregateNetworks() {
      return _aggregateNetworks;
   }

   public Map<String, BgpPeerGroup> getAllPeerGroups() {
      return _allPeerGroups;
   }

   public Ip getClusterId() {
      return _clusterId;
   }

   public int getDefaultMetric() {
      return _masterBgpPeerGroup.getDefaultMetric();
   }

   public boolean getDefaultNeighborActivate() {
      return _defaultNeighborActivate;
   }

   public Map<Ip, IpBgpPeerGroup> getIpPeerGroups() {
      return _ipPeerGroups;
   }

   public MasterBgpPeerGroup getMasterBgpPeerGroup() {
      return _masterBgpPeerGroup;
   }

   public Map<String, NamedBgpPeerGroup> getNamedPeerGroups() {
      return _namedPeerGroups;
   }

   public Set<BgpNetwork> getNetworks() {
      return _networks;
   }

   public BgpPeerGroup getPeerGroup(String name) {
      return _allPeerGroups.get(name);
   }

   public int getPid() {
      return _pid;
   }

   public Map<Protocol, BgpRedistributionPolicy> getRedistributionPolicies() {
      return _redistributionPolicies;
   }

   public Ip getRouterId() {
      return _routerId;
   }

   public void setClusterId(Ip clusterId) {
      _clusterId = clusterId;
   }

   public void setRouterId(Ip routerId) {
      _routerId = routerId;
   }

}
