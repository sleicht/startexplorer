package de.bastiankrol.startexplorer.crossplatform;

import java.io.File;

/**
 * Runtime exec calls for Windows with PowerShell.
 * 
 * @author Bastian Krol
 */
class RuntimeExecCallsWindowsPowerShell extends AbstractRuntimeExecCalls
{

  /**
   * Creates a new instance and initializes the {@link RuntimeExecDelegate}.
   */
  RuntimeExecCallsWindowsPowerShell()
  {
    super();
  }

  /**
   * Creates a new instance with the given {@link RuntimeExecDelegate}.
   * 
   * @param delegate the RuntimeExecDelegate to use
   */
  RuntimeExecCallsWindowsPowerShell(RuntimeExecDelegate delegate)
  {
    super(delegate);
  }

  @Override
  String getCommandForStartFileManager(File file, boolean selectFile)
  {
    if (selectFile && file.isFile())
    {
      return "Explorer.exe /select," + getPath(file);
    }
    else
    {
      return "Explorer.exe /e," + getPath(file);
    }
  }

  @Override
  File getWorkingDirectoryForStartFileManager(File file)
  {
    return null;
  }

  @Override
  String getCommandForStartShell(File file)
  {
    return "cmd.exe /c start /d " + getPath(file) + " powershell.exe";
  }

  @Override
  File getWorkingDirectoryForForStartShell(File file)
  {
    return null;
  }

  @Override
  String getCommandForStartSystemApplication(File file)
  {
    return "cmd.exe /c start /d " + getParentPath(file)
        + " powershell.exe -command " + getPath(file);
  }

  @Override
  File getWorkingDirectoryForForStartSystemApplication(File file)
  {
    return null;
  }

  @Override
  File getWorkingDirectoryForCustomCommand(File file)
  {
    return null;
  }

  public boolean isFileSelectionSupportedByFileManager()
  {
    return true;
  }

  @Override
  boolean doFilePartsWantWrapping()
  {
    return true;
  }
}
