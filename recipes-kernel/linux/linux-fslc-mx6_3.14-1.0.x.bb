# Copyright (C) 2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "FSL Community BSP i.MX6 Linux kernel with backported features and fixes"
DESCRIPTION = "Linux kernel based on Freescale 3.14.28 GA release, used by FSL Community BSP in order to \
provide support for i.MX6 based platforms and include official Linux kernel stable updates, backported \
features and fixes coming from the vendors, kernel community or FSL Community itself."

include linux-fslc.inc

PV .= "+git${SRCPV}"

SRCBRANCH = "3.14-1.0.x-mx6"
SRCREV = "966457723b6d74a65e21c05355b35ff22faa4ad4"

COMPATIBLE_MACHINE = "(mx6)"
