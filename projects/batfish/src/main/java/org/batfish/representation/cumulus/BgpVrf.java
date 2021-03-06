package org.batfish.representation.cumulus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.batfish.datamodel.Ip;

/** BGP configuration for a particular VRF. */
public class BgpVrf implements Serializable {

  private boolean _defaultIpv4Unicast;
  private @Nullable Long _autonomousSystem;
  private @Nullable Boolean _asPathMultipathRelax;
  private final @Nonnull Map<String, BgpNeighbor> _neighbors;
  private @Nullable BgpIpv4UnicastAddressFamily _ipv4Unicast;
  private @Nullable BgpL2vpnEvpnAddressFamily _l2VpnEvpn;
  private @Nullable Ip _routerId;
  private final @Nonnull String _vrfName;
  private @Nullable Long _confederationId;

  public BgpVrf(String vrfName) {
    // the default is true unless explicitly disabled (via "no bgp default ipv4-unicast")
    _defaultIpv4Unicast = true;
    _vrfName = vrfName;
    _neighbors = new HashMap<>();
  }

  public boolean getDefaultIpv4Unicast() {
    return _defaultIpv4Unicast;
  }

  public void setDefaultIpv4Unicast(boolean defaultIpv4Unicast) {
    _defaultIpv4Unicast = defaultIpv4Unicast;
  }

  @Nullable
  public Boolean getAsPathMultipathRelax() {
    return _asPathMultipathRelax;
  }

  public void setAsPathMultipathRelax(@Nullable Boolean asPathMultipathRelax) {
    _asPathMultipathRelax = asPathMultipathRelax;
  }

  public @Nullable Long getAutonomousSystem() {
    return _autonomousSystem;
  }

  public @Nonnull Map<String, BgpNeighbor> getNeighbors() {
    return _neighbors;
  }

  public @Nullable BgpIpv4UnicastAddressFamily getIpv4Unicast() {
    return _ipv4Unicast;
  }

  public @Nullable BgpL2vpnEvpnAddressFamily getL2VpnEvpn() {
    return _l2VpnEvpn;
  }

  public @Nullable Ip getRouterId() {
    return _routerId;
  }

  public @Nonnull String getVrfName() {
    return _vrfName;
  }

  public void setAutonomousSystem(@Nullable Long autonomousSystem) {
    _autonomousSystem = autonomousSystem;
  }

  public void setIpv4Unicast(@Nullable BgpIpv4UnicastAddressFamily ipv4Unicast) {
    _ipv4Unicast = ipv4Unicast;
  }

  public void setL2VpnEvpn(@Nullable BgpL2vpnEvpnAddressFamily l2VpnEvpn) {
    _l2VpnEvpn = l2VpnEvpn;
  }

  public void setRouterId(@Nullable Ip routerId) {
    _routerId = routerId;
  }

  @Nullable
  public Long getConfederationId() {
    return _confederationId;
  }

  public void setConfederationId(@Nullable Long confederationId) {
    _confederationId = confederationId;
  }
}
